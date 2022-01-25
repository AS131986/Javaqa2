import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateRegisteredBonusUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateRegisteredBonusOverLimit() {
        BonusService service = new BonusService();
        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateNoRegisteredBonusOverLimit() {
        BonusService service = new BonusService();
        long amount = 9999_99_99;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateNoRegisteredBonusUnderLimit() {
        BonusService service = new BonusService();
        long amount = 2222_22;
        boolean registered = false;
        long expected = 22;

        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}
