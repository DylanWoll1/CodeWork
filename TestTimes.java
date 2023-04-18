import java.util.ArrayList;
import java.util.List;

public class TestTimes implements TestTimesInterface {

    private static final int MAX_TEST_TIMES = 10;

    private TimeUnits timeUnits;
    private MemoryUnits memoryUnits;

    private List<Long> testTimes;
    private List<Long> memoryUsages;

    public TestTimes() {
        this.timeUnits = TimeUnits.NanoSeconds;
        this.memoryUnits = MemoryUnits.Bytes;
        this.testTimes = new ArrayList<>();
        this.memoryUsages = new ArrayList<>();
    }

    @Override
    public TimeUnits getTimeUnits() {
        return this.timeUnits;
    }

    @Override
    public void setTimeUnits(TimeUnits timeUnits) {
        this.timeUnits = timeUnits;
    }

    @Override
    public MemoryUnits getMemoryUnits() {
        return this.memoryUnits;
    }

    @Override
    public void setMemoryUnits(MemoryUnits memoryUnits) {
        this.memoryUnits = memoryUnits;
    }

    @Override
    public double getLastTestTime() {
        if (testTimes.isEmpty()) {
            return 0;
        }
        long lastTestTime = testTimes.get(testTimes.size() - 1);
        return convertTime(lastTestTime);
    }

    @Override
    public double getLastMemoryUsage() {
        if (memoryUsages.isEmpty()) {
            return 0;
        }
        long lastMemoryUsage = memoryUsages.get(memoryUsages.size() - 1);
        return convertMemoryUsage(lastMemoryUsage);
    }

    @Override
    public double[] getTestTimes() {
        int size = testTimes.size();
        int startIndex = size > MAX_TEST_TIMES ? size - MAX_TEST_TIMES : 0;
        int endIndex = size > MAX_TEST_TIMES ? size : MAX_TEST_TIMES;
        double[] times = new double[MAX_TEST_TIMES];
        for (int i = 0; i < MAX_TEST_TIMES; i++) {
            times[i] = i >= endIndex - startIndex || i >= size ? 0 : convertTime(testTimes.get(startIndex + i));
        }
        return times;
    }

    @Override
    public double[] getMemoryUsages() {
        int size = memoryUsages.size();
        int startIndex = size > MAX_TEST_TIMES ? size - MAX_TEST_TIMES : 0;
        int endIndex = size > MAX_TEST_TIMES ? size : MAX_TEST_TIMES;
        double[] usages = new double[MAX_TEST_TIMES];
        for (int i = 0; i < MAX_TEST_TIMES; i++) {
            usages[i] = i >= endIndex - startIndex || i >= size ? 0 : convertMemoryUsage(memoryUsages.get(startIndex + i));
        }
        return usages;
    }

    @Override
    public double getAverageTestTime() {
        if (testTimes.isEmpty()) {
            return 0;
        }
        long totalTestTime = 0;
        for (Long testTime : testTimes) {
            totalTestTime += testTime;
        }
        double averageTestTime = (double)(totalTestTime / testTimes.size());
        return (averageTestTime);
    }

    @Override
    public double getAverageMemoryUsage() {
        if (memoryUsages.isEmpty()) {
            return 0;
        }
        long totalMemoryUsage = 0;
        for (Long memoryUsage : memoryUsages) {
            totalMemoryUsage += memoryUsage;
        }
        return convertMemoryUsage(totalMemoryUsage / memoryUsages.size());
    }

    private double convertMemoryUsage(double bytes) {
        switch (memoryUnits) {
            case Bytes:
                return bytes;
            case KiloBytes:
                return bytes / 1024.0;
            case MegaBytes:
                return bytes / (1024.0 * 1024.0);
            default:
                return 0.0;
        }
    }
  
    private double convertTime(long time) {
        double convertedTime;
        switch (timeUnits) {
            case Seconds:
                convertedTime = time / 1_000_000_000.0;
                break;
            case MilliSeconds:
                convertedTime = time / 1_000_000.0;
                break;
            case MicroSeconds:
                convertedTime = time / 1_000.0;
                break;
            case NanoSeconds:
            default:
                convertedTime = time;
        }
        return convertedTime;
    }

	@Override
	public void resetTestTimes() {
	    testTimes.clear();
	    memoryUsages.clear();
	}

	@Override
	public void addTestTime(long runTime) {
	    testTimes.add(runTime);
	    long memoryUsage = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	    memoryUsages.add(memoryUsage);
	}

}
        