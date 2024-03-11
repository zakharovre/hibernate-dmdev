package ru.zakharovre.hibernatedmdev;

import org.junit.jupiter.api.Test;
import ru.zakharovre.hibernatedmdev.entity.User;

import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Optional;

class HibernateRunnerTest {

    @Test
    void checkReflectionApi() {
        User user = User.builder()
                .username("ivan_ivanov")
                .firstname("ivan")
                .lastname("ivanov")
                .age(31)
                .birthDate(LocalDate.of(2000,1,2))
                .build();

        String tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
                .map(Table::name)
                .orElse(user.getClass().getName());
    }
}
