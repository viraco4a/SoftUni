package appenders;

import layouts.Layout;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortedAppender extends AppenderImpl {
    private Map<String, List<String>> data;

    public SortedAppender(Layout layout) {
        super(layout);
        this.initialization();
    }

    public SortedAppender(Layout layout, String reportLevel) {
        super(layout, reportLevel);
        this.initialization();
    }

    private void initialization() {
        this.data = new LinkedHashMap<>();
        this.data.put("INFO", new ArrayList<>());
        this.data.put("WARNING", new ArrayList<>());
        this.data.put("ERROR", new ArrayList<>());
        this.data.put("CRITICAL", new ArrayList<>());
        this.data.put("FATAL", new ArrayList<>());
    }

    @Override
    public void append(String date, String reportLevel, String message) {
        if (!super.canAppend(reportLevel)) {
            return;
        }
        String formatted = super.formatMessage(date, reportLevel, message);
        this.addToLog(reportLevel, formatted);
        super.successfullyAppended();
    }

    private void addToLog(String reportLevel, String message) {
        this.data.get(reportLevel).add(message);
    }

    public String getReportLevelLog(String reportLevel) {
        if (!this.data.containsKey(reportLevel)) {
            return "Unsupported Report level";
        }
        StringBuilder log = new StringBuilder();
        log.append("Log:").append(System.lineSeparator());
        int counter = 0;
        for (String message : data.get(reportLevel)) {
            log.append("#").append(++counter)
                    .append(message).append(System.lineSeparator());
        }
        return log.toString().trim();
    }

    @Override
    public String appenderStatistics() {
        StringBuilder info = new StringBuilder();
        info.append(super.appenderStatistics())
                .append(System.lineSeparator());
        for (Map.Entry<String, List<String>> level : data.entrySet()) {
            String reportLevel = level.getKey();
            info
                    .append("Report level: ").append(reportLevel)
                    .append(System.lineSeparator())
                    .append(this.getReportLevelLog(reportLevel))
                    .append(System.lineSeparator());
        }

        return info.toString();
    }
}
