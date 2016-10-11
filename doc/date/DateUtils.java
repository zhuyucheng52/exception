public class DateUtils {
    /**
	 * <p><b>获取指定日期后一天凌晨0点, 如果传入参数为null，则返回null</b></p>
     * <p>For Example: 2016-09-14 12:45:32.000 returns 2016-09-15 00:00:00.000</p>
	 * <p>             2016-10-31 12:45:32.000 returns 2016-11-01 00:00:00.000</p>
	 * @param date
	 * @return
	 */
    public static Date ceiling(final Date date) {
        if (null == date) {
            return null;
        }

        Date d = floor(date);
        d = DateUtils.addDays(d, 1);
        return d;
    }

    /**
	 * <p><b>指定日期的凌晨0点，如果传入传入参数为null，则返回null</b></p>
	 * <p>For Example: 2016-09-14 12:45:32.000 returns 2016-09-14 00:00:00.000</p>
	 * <p>             2016-10-31 12:45:32.000 returns 2016-10-31 00:00:00.000</p>
	 * @param date
	 * @return
	 */
    public static Date floor(final Date date) {
        if (null == date) {
            return null;
        }

        Date d = DateUtils.setHours(date, 0);
        d = DateUtils.setMinutes(d, 0);
        d = DateUtils.setSeconds(d, 0);
        d = DateUtils.setMilliseconds(d, 0);
        return d;
    }
}
