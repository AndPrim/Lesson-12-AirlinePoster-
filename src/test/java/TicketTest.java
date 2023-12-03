import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    AviaSouls service = new AviaSouls();

    Ticket ticket1 = new Ticket("Челябинск", "Сочи", 10_000, 12_00, 14_00);
    Ticket ticket2 = new Ticket("Челябинск", "Москва", 7_000, 14_00, 15_30);
    Ticket ticket3 = new Ticket("Челябинск", "Иркутск", 13_000, 13_00, 16_00);
    Ticket ticket4 = new Ticket("Екатеринбург", "Владивосток", 23_000, 9_00, 17_00);
    Ticket ticket5 = new Ticket("Уфа", "Симферополь", 17_000, 8_00, 10_30);
    Ticket ticket6 = new Ticket("Челябинск", "Москва", 3_000, 4_00, 8_30);
    Ticket ticket7 = new Ticket("Челябинск", "Москва", 4_000, 8_00, 10_30);
    Ticket ticket8 = new Ticket("Челябинск", "Москва", 10_000, 15_00, 16_00);


    @Test
    void compareToPriceSearch() {
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);


        Ticket[] expected = {ticket2, ticket1, ticket3, ticket5, ticket4};
        Ticket[] actual = service.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void compareToPrice() {
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);


        Ticket[] expected = {ticket6, ticket7, ticket2, ticket8};
        Ticket[] actual = service.search("Челябинск", "Москва");
        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    void compareToPriceSearchOne() {
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);


        Ticket[] expected = {ticket2};
        Ticket[] actual = service.search("Челябинск", "Москва");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void compareToPriceSearchNow() {
        service.add(ticket1);
        service.add(ticket5);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);


        Ticket[] expected = {};
        Ticket[] actual = service.search("Челябинск", "Москва");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void comparatorTest() {
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        TicketTimeComparator titico = new TicketTimeComparator();
        Ticket[] pov = service.findAll();
        Arrays.sort(pov, titico);


        Ticket[] expected = {ticket2, ticket1, ticket5, ticket3, ticket4};
        Ticket[] actual = pov;
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void comparatorToPrice() {
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);
        service.add(ticket6);
        service.add(ticket7);
        service.add(ticket8);


        Ticket[] expected = {ticket8, ticket2, ticket7, ticket6};
        Ticket[] actual = service.searchAndSortBy("Челябинск", "Москва");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void comparatorToPriceOne() {
        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);


        Ticket[] expected = {ticket2};
        Ticket[] actual = service.searchAndSortBy("Челябинск", "Москва");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void comparatorToPriceNow() {
        service.add(ticket1);
        service.add(ticket5);
        service.add(ticket3);
        service.add(ticket4);
        service.add(ticket5);


        Ticket[] expected = {};
        Ticket[] actual = service.searchAndSortBy("Челябинск", "Москва");
        Assertions.assertArrayEquals(expected, actual);
    }

}