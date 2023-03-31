package com.reign.lofty.applicationAPI.utils;

import java.util.Random;
import java.util.UUID;

public class UUIDGenerator {
    
    private static long get64LeastSignificantBitsForVersion1() {
        Random random = new Random();
        long random63BitLong = random.nextLong() & 0x3FFFFFFFFFFFFFFFL;
        long variant3BitFlag = 0x8000000000000000L;
        return random63BitLong + variant3BitFlag;
    }

    private static long get64MostSignificantBitsForVersion1() {
        final long timeForUuidIn100Nanos = System.currentTimeMillis();
        final long time_low = (timeForUuidIn100Nanos & 0x0000_0000_FFFF_FFFFL) << 32;
        final long time_mid = ((timeForUuidIn100Nanos >> 32) & 0xFFFF) << 16;
        final long version = 1 << 12; final long time_hi = ((timeForUuidIn100Nanos >> 48) & 0x0FFF);
        return time_low + time_mid + version + time_hi;
    }

    public static UUID generateID() {
        long most64SigBits = get64MostSignificantBitsForVersion1();
        long least64SigBits = get64LeastSignificantBitsForVersion1();
        return new UUID(most64SigBits, least64SigBits);
    }
}