package appenders;

import layouts.Layout;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class AppenderImpl implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private Set<String> availableReportLevels;
    private int msgAppendedCounter;

    public AppenderImpl(Layout layout) {
        this.initialization(layout, "INFO");
    }

    public AppenderImpl(Layout layout, String reportLevel) {
        this.initialization(layout, reportLevel);
    }

    private void initialization(Layout layout, String reportLevel) {
        this.availableReportLevels = new HashSet<>();
        this.layout = layout;
        this.reportLevel = ReportLevel.valueOf(reportLevel);
        this.msgAppendedCounter = 0;
        this.setReportLevel(this.reportLevel);
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
        String[] levels = reportLevel.getAvailableReportLevels().split(", ");
        this.availableReportLevels.clear();
        this.availableReportLevels.addAll(Arrays.asList(levels));
    }

    public Layout getLayout() {
        return this.layout;
    }

    public int getMsgAppendedCounter() {
        return this.msgAppendedCounter;
    }

    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    protected String formatMessage(String date, String reportLevel, String message) {
        return this.getLayout().formatMessage(date, reportLevel, message);
    }

    protected void successfullyAppended() {
        this.msgAppendedCounter++;
    }

    @Override
    public boolean canAppend(String reportLevel) {
        return this.availableReportLevels.contains(reportLevel);
    }

    @Override
    public String appenderStatistics() {
        String appenderType = this.getClass().getSimpleName();
        String layoutType = this.layout.getClass().getSimpleName();
        String reportLevel = this.getReportLevel().getName();
        return String.format("Appender type: %s, layouts.Layout type: %s, Report level: %s, Messages appended: %d"
                , appenderType
                , layoutType
                , reportLevel
                , this.getMsgAppendedCounter());
    }
}
