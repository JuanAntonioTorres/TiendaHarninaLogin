package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.Enumeration;

public class GeneradorDeObjetoConSession {

    public void generarObjeto(HttpSession session , Object objeto) throws IllegalAccessException {

        Field[] camposDelObjeto = objeto.getClass().getDeclaredFields();

        for (int i = 0; i < camposDelObjeto.length; i++) {

            camposDelObjeto[i].set(objeto,session.getAttribute(camposDelObjeto[i].getName()));
        }
    }
}
