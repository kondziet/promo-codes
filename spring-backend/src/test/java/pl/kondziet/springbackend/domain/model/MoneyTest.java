package pl.kondziet.springbackend.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void currenciesShouldMatch() {
        //given:
        var money1 = Money.zero("USD");
        var money2 = Money.zero("USD");

        //expect:
        assertTrue(money1.currencyMatches(money2));
    }

}