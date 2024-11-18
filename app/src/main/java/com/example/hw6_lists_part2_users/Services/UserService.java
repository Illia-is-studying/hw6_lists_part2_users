package com.example.hw6_lists_part2_users.Services;

import com.example.hw6_lists_part2_users.Models.Country;
import com.example.hw6_lists_part2_users.Models.UserModel;
import com.example.hw6_lists_part2_users.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class UserService {
    private static final List<UserModel> userList;
    private static int[] profileResourceIds;
    private static String[] firstNames;
    private static String[] lastNames;
    private static Country[] countries;

    private final static int LOWER_AGE_LIMIT;
    private final static int UPPER_AGE_LIMIT;

    static {
        LOWER_AGE_LIMIT = 14;
        UPPER_AGE_LIMIT = 99;
        userList = new ArrayList<>();

        fillProfileResourceIds();
        fillNames();
        fillCountries();

        //:) bonus user
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(1945, Calendar.JANUARY, 16); //Is it close?
        long birthDateInUTC = birthDate.getTimeInMillis();
        userList.add(new UserModel("Ukraine", "Kryvyi Rig",
                "Inga", "Kovnytska", birthDateInUTC, profileResourceIds[4]));
        fillArray();
    }

    public static List<UserModel> getUserList() {
        return userList;
    }

    private static void fillArray() {
        Random random = new Random();

        for(int i = 0; i < 100; i++) {
            Country country = countries[random.nextInt(3)];
            String cityName = country.getCities()[random.nextInt(5)];
            String countryName = country.getName();
            String firstName = firstNames[random.nextInt(10)];
            String lastName = lastNames[random.nextInt(10)];

            int randomAgeYear = LOWER_AGE_LIMIT +
                    (int) (Math.random() * ((UPPER_AGE_LIMIT - LOWER_AGE_LIMIT) + 1));

            long ageUTC = AgeService.getLongUTCByAge(randomAgeYear, random);
            int avatar = profileResourceIds[4];

            if(randomAgeYear < 60) {
                avatar = profileResourceIds[random.nextInt(4)];
            }

            userList.add(new UserModel(countryName, cityName, firstName, lastName, ageUTC, avatar));
        }
    }

    private static void fillProfileResourceIds() {
        profileResourceIds = new int[5];
        profileResourceIds[0] = R.drawable.man;
        profileResourceIds[1] = R.drawable.black_man;
        profileResourceIds[2] = R.drawable.woman;
        profileResourceIds[3] = R.drawable.black_woman;
        profileResourceIds[4] = R.drawable.old_man;
    }

    private static void fillNames() {
        firstNames = new String[10];
        firstNames[0] = "John";
        firstNames[1] = "Emma";
        firstNames[2] = "Michael";
        firstNames[3] = "Sophia";
        firstNames[4] = "David";
        firstNames[5] = "Olivia";
        firstNames[6] = "James";
        firstNames[7] = "Ava";
        firstNames[8] = "Robert";
        firstNames[9] = "Isabella";

        lastNames = new String[10];
        lastNames[0] = "Smith";
        lastNames[1] = "Johnson";
        lastNames[2] = "Brown";
        lastNames[3] = "Williams";
        lastNames[4] = "Jones";
        lastNames[5] = "Miller";
        lastNames[6] = "Davis";
        lastNames[7] = "Garcia";
        lastNames[8] = "Martinez";
        lastNames[9] = "Rodriguez";
    }

    private static void fillCountries() {
        countries = new Country[3];

        countries[0] = new Country("Ukraine",
                new String[]{"Kyiv", "Lviv", "Odesa", "Kharkiv", "Dnipro"});
        countries[1] = new Country("USA",
                new String[]{"New York", "Los Angeles", "Chicago", "Houston", "Phoenix"});
        countries[2] = new Country("Japan",
                new String[]{"Tokyo", "Osaka", "Kyoto", "Nagoya", "Sapporo"});
    }
}
