Java locale Kazakh Check is an small program for checking installation [Kazakh Locale](https://github.com/valery1707/java-locale-kazakh) to JVM

# Download

Download latest jar-file from [GitHub Releases](https://github.com/valery1707/java-locale-kazakh-check/releases).

# Run

Run executable jar from command line:

```bash
$ java -jar locale-kazakh-check-{version}.jar
```

# Sample check result

## Locale not installed yet

```
Checking Java version: [1.7.0_51]                                       [OK]
Available locales are: [ms_MY, ar_QA, is_IS, fi_FI, pl, en_MT, it_CH, nl_BE, ar_SA, ar_IQ, es_PR, es_CL, fi, de_AT, da, en_GB, es_PA, sr, ar_YE, mk_MK, mk, en_CA, vi_VN, nl_NL, es_US, zh_CN, es_HN, en_US, fr, th, ar, ar_MA, lv, de, in_ID, hr, en_ZA, ko_KR, ar_TN, in, ja, sr_RS, be_BY, zh_TW, ar_SD, pt, is, ja_JP_JP_#u-ca-japanese, es_BO, ar_DZ, ms, es_AR, ar_AE, fr_CA, sl, es, lt_LT, sr_ME_#Latn, ar_SY, ru_RU, fr_BE, es_ES, bg, iw_IL, sv, en, iw, da_DK, es_CR, zh_HK, zh, ca_ES, th_TH, uk_UA, es_DO, es_VE, pl_PL, ar_LY, ar_JO, it, uk, hu_HU, ga, es_GT, es_PY, bg_BG, hr_HR, sr_BA_#Latn, ro_RO, fr_LU, no, lt, en_SG, es_EC, sr_BA, es_NI, sk, ru, mt, es_SV, nl, hi_IN, et, el_GR, sl_SI, it_IT, ja_JP, de_LU, fr_CH, mt_MT, ar_BH, sq, vi, sr_ME, pt_BR, no_NO, el, de_CH, zh_SG, ar_KW, ar_EG, ga_IE, es_PE, cs_CZ, tr_TR, cs, es_UY, en_IE, en_IN, ar_OM, sr_CS, ca, be, sr__#Latn, ko, sq_AL, pt_PT, lv_LV, sr_RS_#Latn, sk_SK, es_MX, en_AU, no_NO_NY, en_NZ, sv_SE, ro, ar_LB, de_DE, th_TH_TH_#u-nu-thai, tr, es_CO, en_PH, et_EE, el_CY, hu, fr_FR]

Checking locale: kk
Is locale available in JVM: false                                     [FAIL]
Checking date formatting...
  Checking full date format: [Thursday, December 31, 2009 11:59:59 PM MSK] [FAIL]
  Checking long date format: [December 31, 2009 11:59:59 PM MSK]      [FAIL]
  Checking medium date format: [Dec 31, 2009 11:59:59 PM]             [FAIL]
  Checking short date format: [12/31/09 11:59 PM]                     [FAIL]
Checking number formatting...
  Checking decimal number format: [23,124,213.456]                    [FAIL]
  Checking currency format: [¤ 23,124,213.46]                         [FAIL]

Checking locale: kk_KZ
Is locale available in JVM: false                                     [FAIL]
Checking date formatting...
  Checking full date format: [Thursday, December 31, 2009 11:59:59 PM MSK] [FAIL]
  Checking long date format: [December 31, 2009 11:59:59 PM MSK]      [FAIL]
  Checking medium date format: [Dec 31, 2009 11:59:59 PM]             [FAIL]
  Checking short date format: [12/31/09 11:59 PM]                     [FAIL]
Checking number formatting...
  Checking decimal number format: [23,124,213.456]                    [FAIL]
  Checking currency format: [KZT 23,124,213.46]                       [FAIL]

Checking complete!
Status locale kk                                                      [FAIL]
Status locale kk_KZ                                                   [FAIL]
TOTAL STATUS                                                          [FAIL]
```

## Correctly installed locale

```
Checking Java version: [1.7.0_51]                                       [OK]
Available locales are: [ms_MY, ar_QA, is_IS, fi_FI, pl, en_MT, it_CH, nl_BE, ar_SA, ar_IQ, es_PR, es_CL, fi, de_AT, da, en_GB, es_PA, sr, ar_YE, mk_MK, mk, en_CA, vi_VN, nl_NL, es_US, zh_CN, es_HN, en_US, fr, th, ar, ar_MA, lv, de, in_ID, hr, en_ZA, ko_KR, ar_TN, in, ja, sr_RS, be_BY, zh_TW, ar_SD, pt, is, ja_JP_JP_#u-ca-japanese, es_BO, ar_DZ, ms, es_AR, ar_AE, fr_CA, sl, es, lt_LT, sr_ME_#Latn, ar_SY, ru_RU, fr_BE, es_ES, bg, iw_IL, sv, en, iw, da_DK, es_CR, zh_HK, zh, ca_ES, th_TH, uk_UA, es_DO, es_VE, pl_PL, ar_LY, ar_JO, it, uk, hu_HU, ga, es_GT, es_PY, bg_BG, kk_KZ, hr_HR, sr_BA_#Latn, ro_RO, fr_LU, no, lt, en_SG, es_EC, sr_BA, es_NI, sk, ru, mt, es_SV, nl, hi_IN, et, el_GR, sl_SI, it_IT, ja_JP, de_LU, fr_CH, mt_MT, ar_BH, sq, vi, sr_ME, pt_BR, no_NO, el, de_CH, zh_SG, ar_KW, ar_EG, ga_IE, es_PE, cs_CZ, tr_TR, cs, es_UY, en_IE, en_IN, kk, ar_OM, sr_CS, ca, be, sr__#Latn, ko, sq_AL, pt_PT, lv_LV, sr_RS_#Latn, sk_SK, es_MX, en_AU, no_NO_NY, en_NZ, sv_SE, ro, ar_LB, de_DE, th_TH_TH_#u-nu-thai, tr, es_CO, en_PH, et_EE, el_CY, hu, fr_FR]

Checking locale: kk
Is locale available in JVM: true                                        [OK]
Checking date formatting...
  Checking full date format: [Жұма 31 Желтоқсан 2009 жыл 23:59:59 MSK]  [OK]
  Checking long date format: [31 Желтоқсан 2009 жыл 23:59:59 MSK]       [OK]
  Checking medium date format: [31 Желтоқсан 2009 ж. 23:59:59]          [OK]
  Checking short date format: [31.12.09 23:59]                          [OK]
Checking number formatting...
  Checking decimal number format: [23 124 213,456]                      [OK]
  Checking currency format: [23 124 213,46 тңг]                         [OK]

Checking locale: kk_KZ
Is locale available in JVM: true                                        [OK]
Checking date formatting...
  Checking full date format: [Жұма 31 Желтоқсан 2009 жыл 23:59:59 MSK]  [OK]
  Checking long date format: [31 Желтоқсан 2009 жыл 23:59:59 MSK]       [OK]
  Checking medium date format: [31 Желтоқсан 2009 ж. 23:59:59]          [OK]
  Checking short date format: [31.12.09 23:59]                          [OK]
Checking number formatting...
  Checking decimal number format: [23 124 213,456]                      [OK]
  Checking currency format: [23 124 213,46 тңг]                         [OK]

Checking complete!
Status locale kk                                                        [OK]
Status locale kk_KZ                                                     [OK]
Total status                                                            [OK]
```
