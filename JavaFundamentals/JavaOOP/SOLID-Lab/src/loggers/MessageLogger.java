package loggers;

import appenders.Appender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageLogger implements Logger {
    private List<Appender> appenders;

    public MessageLogger(Appender... appender) {
        this.appenders = new ArrayList<>();
        this.init(appender);
    }

    private void init(Appender[] appender) {
        this.appenders.addAll(Arrays.asList(appender));
    }

    @Override
    public void logError(String date, String message) {
        this.logMessages(date, this.getReportLevel(), message);
    }

    @Override
    public void logInfo(String date, String message) {
        this.logMessages(date, this.getReportLevel(), message);
    }

    @Override
    public void logWarning(String date, String message) {
        this.logMessages(date, this.getReportLevel(), message);
    }

    @Override
    public void logCritical(String date, String message) {
        this.logMessages(date, this.getReportLevel(), message);
    }

    @Override
    public void logFatal(String date, String message) {
        this.logMessages(date, this.getReportLevel(), message);
    }

    private String getReportLevel() {
        return new Throwable()
                .getStackTrace()[1]
                .getMethodName()
                .replace("log", "")
                .toLowerCase();
    }

    public List<Appender> getAppenders() {
        return this.appenders;
    }

    private void logMessages(String date, String reportLevel, String message) {
        for (Appender appender : this.getAppenders()) {
            if (appender.canAppend(reportLevel)) {
                appender.append(date, reportLevel, message);
            }
        }
    }

    @Override
    public String logStatistics() {
        StringBuilder stats = new StringBuilder();
        for (Appender appender : this.getAppenders()) {
            stats
                    .append(appender.appenderStatistics())
                    .append(System.lineSeparator());
        }
        return stats.toString().trim();
    }
}
