package com.example.hw6_lists_part2_users.Services;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Random;

public class AgeService {
    public static String getAgeByLongUTC(long ageUTC) {
        long currentTimeUTC = System.currentTimeMillis();
        long ageInMilliseconds = currentTimeUTC - ageUTC;
        long ageInYear = ageInMilliseconds / (1000L * 60 * 60 * 24 * 365);
        return String.valueOf(ageInYear);
    }

    public static long getLongUTCByAge(int age, Random random) {
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(
                LocalDateTime.now().getYear() - age,
                random.nextInt(12),
                random.nextInt(30));

        return birthDate.getTimeInMillis();
    }
}
