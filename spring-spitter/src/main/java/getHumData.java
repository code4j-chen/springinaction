
public class getHumData {
	private final static double[][] HumidityTable = {

			// TEMP/HUMI 20% 25% 30% 35% 40% 45% 50% 55% 60% 65% 70% 75% 80% 85%
			// 90%
			/* 0 */{ 0, 0, 6400000, 2900000, 1400000, 700000, 370000, 190000,
					105000, 62000, 38000, 23000, 15500, 10500, 7100 },
			/* 5 */{ 0, 10000000, 4600000, 2100000, 1000000, 500000, 260000,
					140000, 80000, 48000, 30000, 18000, 12000, 8200, 5300 },
			/* 10 */{ 0, 7000000, 3200000, 1500000, 750000, 380000, 200000,
					110000, 62000, 37000, 24000, 15000, 10000, 6800, 4700 },
			/* 15 */{ 10000000, 5000000, 2300000, 1100000, 540000, 280000,
					150000, 84000, 50000, 30000, 19000, 12000, 8000, 5500, 4000 },
			/* 20 */{ 6700000, 3400000, 1750000, 850000, 420000, 210000,
					115000, 64000, 39000, 24000, 15500, 10000, 7000, 4800, 3300 },
			/* 25 */{ 5000000, 2600000, 1300000, 630000, 310000, 160000, 87000,
					49000, 31000, 19500, 13000, 8400, 5700, 4000, 2800 },
			/* 30 */{ 3900000, 1900000, 970000, 460000, 235000, 125000, 69000,
					39000, 25000, 16000, 10500, 7200, 5000, 3500, 2500 },
			/* 35 */{ 3000000, 1500000, 740000, 380000, 190000, 100000, 56000,
					33000, 20000, 13000, 9000, 6200, 4300, 3100, 2200 },
			/* 40 */{ 2400000, 1100000, 570000, 280000, 140000, 78000, 45000,
					27000, 17500, 11500, 8000, 5600, 3900, 2800, 2000 },
			/* 45 */{ 1750000, 880000, 420000, 210000, 110000, 64000, 38000,
					24000, 15000, 10000, 7000, 4900, 3400, 2400, 1800 },
			/* 50 */{ 1450000, 700000, 340000, 170000, 88000, 50000, 31000,
					17000, 13000, 8600, 6000, 4200, 3000, 2100, 1500 },
			/* 55 */{ 1210000, 575000, 277500, 137500, 72500, 42000, 26000,
					15500, 11200, 7700, 5400, 3800, 2750, 1950, 1400 },
			/* 60 */{ 970000, 450000, 215000, 105000, 57000, 34000, 21000,
					14000, 9400, 6800, 4800, 3400, 2500, 1800, 1300 } };

	private static double m_HumiVo;
	private static double m_HumiData;
	private static double m_HumiR;
	private static double m_HumiByTemp[];
	private static double m_HumiHighestR;
	private static double m_HumiLowestR;
	private static int m_HumiNum1;
	private static int m_HumiNum2;
	private static int m_HumiI;
	private static int m_HumiJ;

	public static double CalculateHumidity(byte hiByte, byte lowByte,
			double temp) {
		if (temp > 100) {
			temp = temp - 100;
		}
		m_HumiByTemp = new double[(HumidityTable[0].length - 1) * 5 + 1];
		m_HumiVo = ((3.3 / 1024) * ((lowByte & 0xff) | ((hiByte & 0xff) << 8)));
		m_HumiData = 0;
		m_HumiR = 0;
		// 20% ~ 90% for specific temperature
		for (m_HumiI = 0; m_HumiI < m_HumiByTemp.length; m_HumiI++) {
			m_HumiByTemp[m_HumiI] = 0;
		}
		m_HumiHighestR = 0;
		m_HumiLowestR = 0;

		do {
			// over specification
			if (((int) temp < 0) || ((int) temp > 60)) {
				// debug
				// trace1("HUMI - OVER SPEC; temp:" + temp +
				// "; temp < 0 || > 60");
				break;
			}

			// calculate main humidity
			if (((int) temp % 5) == 0) {
				for (m_HumiI = 0, m_HumiJ = 0; m_HumiI < m_HumiByTemp.length; m_HumiI++) {
					if ((m_HumiI % 5) == 0) {
						m_HumiByTemp[m_HumiI] = HumidityTable[(int) temp / 5][m_HumiJ];
						m_HumiJ++;
					}
				}
			} else {
				m_HumiNum1 = (int) temp / 5;
				m_HumiNum2 = (int) temp % 5;

				for (m_HumiI = 0, m_HumiJ = 0; m_HumiI < m_HumiByTemp.length; m_HumiI++) {
					if ((m_HumiI % 5) == 0) {
						if (HumidityTable[m_HumiNum1 + 1][m_HumiJ] == 10000000) {
							m_HumiByTemp[m_HumiI] = 0;
						} else {
							m_HumiByTemp[m_HumiI] = HumidityTable[m_HumiNum1][m_HumiJ]
									+ (((HumidityTable[m_HumiNum1 + 1][m_HumiJ] - HumidityTable[m_HumiNum1][m_HumiJ]) / 5) * m_HumiNum2);
						}
						m_HumiJ++;
					}
				}
			}

			// fill each humidity for specific temperature
			for (m_HumiI = 0, m_HumiJ = 0; m_HumiI < m_HumiByTemp.length; m_HumiI++) {
				if ((m_HumiI % 5) != 0) {
					if (m_HumiByTemp[(m_HumiJ - 1) * 5] > m_HumiByTemp[m_HumiJ * 5]) {
						m_HumiByTemp[m_HumiI] = m_HumiByTemp[(m_HumiJ - 1) * 5]
								- (((m_HumiByTemp[(m_HumiJ - 1) * 5] - m_HumiByTemp[m_HumiJ * 5]) / 5) * (m_HumiI % 5));
					} else {
						m_HumiByTemp[m_HumiI] = 0;
					}
				} else {
					m_HumiJ++;
				}
			}

			// debug
			/*
			 * for (m_HumiI = 0; m_HumiI < m_HumiByTemp.length; m_HumiI++) {
			 * trace1("HUMI - m_HumiByTemp[" + (m_HumiI + 20) + "] : " +
			 * m_HumiByTemp[m_HumiI]); }
			 */

			// calculate R
			m_HumiR = 49900 * ((3.3 / m_HumiVo) - 1);

			for (m_HumiI = 0; m_HumiI < m_HumiByTemp.length; m_HumiI++) {
				if (m_HumiByTemp[m_HumiI] > m_HumiHighestR) {
					m_HumiHighestR = m_HumiByTemp[m_HumiI];
				}
			}
			m_HumiLowestR = m_HumiByTemp[m_HumiByTemp.length - 1];

			if ((m_HumiR < m_HumiLowestR) || (m_HumiR > m_HumiHighestR)) {
				// debug
				// trace1("HUMI - OVER SPEC; R:" + m_HumiR + "; (R < lowestR<" +
				// m_HumiLowestR + ">) || (R > highestR<" + m_HumiHighestR +
				// ">)");
				break;
			}

			if (m_HumiR == m_HumiLowestR) {
				// debug
				// trace1("HUMI - TOUCH HIGHEST HUMI; R:" + m_HumiR +
				// "; lowestR:" + m_HumiLowestR);
				m_HumiData = 90;
				break;
			}

			for (m_HumiI = 0; m_HumiI < m_HumiByTemp.length - 1; m_HumiI++) {
				if ((m_HumiR <= m_HumiByTemp[m_HumiI])
						&& (m_HumiR > m_HumiByTemp[m_HumiI + 1])) {
					m_HumiData = m_HumiI + 20;
					break;
				}
			}

		} while (false);

		// debug
		// trace1("HUMI - data:" + m_HumiData);
		return m_HumiData;
	}

	public static void main(String[] args) {
//		System.out.println(CalculateHumidity());
	}
}
