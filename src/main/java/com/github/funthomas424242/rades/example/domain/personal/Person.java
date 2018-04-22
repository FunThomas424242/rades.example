package com.github.funthomas424242.rades.example.domain.personal;


import com.github.funthomas424242.rades.example.domain.DomainObject;
import com.github.funthomas424242.rades.example.domain.Name;
import com.github.funthomas424242.rades.example.domain.zeit.Abwesenheit;
import com.github.funthomas424242.rades.example.domain.zeit.Datum;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@DomainObject
public class Person {

    @NotNull
    protected Datum birthday;

    @NotNull
    protected Name nachname;

    @NotNull
    protected Name vorname;

    protected List<Abwesenheit> abwesenheiten;

    public int berechneAlter() {
        return this.berechneAlterZum(
                Datum.fromLocalDate(LocalDate.now()));
    }

    public int berechneAlterZum(final Datum datum) {
        if (datum == null) {
            throw new IllegalArgumentException("Es wird ein Datum zur Berechnung benötigt.");
        }
        final Period period
                = birthday.toLocalDate().until(datum.toLocalDate());
        return period.getYears();
    }

    @Override
    public String toString(){
        return nachname +", "+vorname;
    }

}
