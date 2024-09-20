package com.example.demo_interceptor_2.interceptors;

import com.example.demo_interceptor_2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    //inizializzo una lista di sei mesi
    private final List<Month> months = new ArrayList<>();
    public MonthInterceptor() {
        months.add(new Month(1, "January", "Gennaio", "Januar"));
        months.add(new Month(2, "February", "Febbraio", "Februar"));
        months.add(new Month(3, "March", "Marzo", "März"));
        months.add(new Month(4, "April", "Aprile", "April"));
        months.add(new Month(5, "May", "Maggio", "Mai"));
        months.add(new Month(6, "June", "Giugno", "Juni"));
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //richiesta monthNumber
        String monthNumberString = request.getHeader("monthNumber");
        //se la stringa è vuota o null restituisce un errore HTTP 400
        if (monthNumberString == null || monthNumberString.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Bad request, missing or empty values");
            //throw new Exception("This endpoint is blocked");
            return false;
        }
            //convertiamo la stringa monthNumberString in un Integer
            Integer monthNumber = Integer.parseInt(monthNumberString);
            //cerchiamo il mese corrispondete usando Optional
            Optional<Month> monthOptional = months.stream()
                    .filter(month -> month.getMonthNumber().equals(monthNumber))
                    .findFirst();
            //se il mese dentro l'oggetto optional è presente viene utilizzato, altrimenti se è vuoto viene restituito un oggetto con valori di default
            Month month = monthOptional.orElse(new Month(0, "nope", "nope", "nope"));
            //impostiamo la richiesta col mese trovato o il mese vuoto
            request.setAttribute("month", month);
            //la response sarà HTTP 200 OK
            response.setStatus(HttpServletResponse.SC_OK);
            //ritorno true per far proseguire la richiesta sul controller
            return true;

    }
}
