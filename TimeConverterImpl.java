package com.ubs.opsit.interviews;

import java.util.Arrays;

public class TimeConverterImpl implements TimeConverter{
	
	/*
	 * Converts berlin time to String.
	 * @see com.ubs.opsit.interviews.TimeConverter#convertTime(java.lang.String)
	 */
	@Override
	public String convertTime(String aTime) {
		int[] parts = Arrays.asList(aTime.split(":")).stream().mapToInt(Integer::parseInt).toArray();
        String[] strArray =  new String[] {
                getSeconds(parts[2]),
                getTopHours(parts[0]),
                getBottomHours(parts[0]),
                getTopMinutes(parts[1]),
                getBottomMinutes(parts[1])
        };
        return Arrays.toString(strArray).replaceAll(",", "\n");
    }

    protected String getSeconds(int number) {
        if (number % 2 == 0) return "Y";
        else return "O";
    }

    protected String getTopHours(int number) {
        return getOnOff(4, getTopNumberOfOnSigns(number));
    }

    protected String getBottomHours(int number) {
        return getOnOff(4, number % 5);
    }

    protected String getTopMinutes(int number) {
        return getOnOff(11, getTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR");
    }

    protected String getBottomMinutes(int number) {
        return getOnOff(4, number % 5, "Y");
    }

    protected String getOnOff(int lamps, int onSigns) {
        return getOnOff(lamps, onSigns, "R");
    }
    protected String getOnOff(int lamps, int onSigns, String onSign) {
        String out = "";
        for (int i = 0; i < onSigns; i++) {
            out += onSign;
        }
        for (int i = 0; i < (lamps - onSigns); i++) {
            out += "O";
        }
        return out;
    }

    protected int getTopNumberOfOnSigns(int number) {
        return (number - (number % 5)) / 5;
    }
}
