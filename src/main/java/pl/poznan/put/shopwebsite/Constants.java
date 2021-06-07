package pl.poznan.put.shopwebsite;

import org.springframework.ui.Model;

import java.text.SimpleDateFormat;


public class Constants {

    public static final boolean DEBUG = true;

    public static final String BULMA_PATH = "/css/bulma.min.css";
    public static final String BULMA_DEBUG_PATH = "/css/bulma.css";

    public static final String BULMA_CAROUSEL_PATH = "/css/bulma-carousel.min.css";
    public static final String BULMA_CAROUSEL_DEBUG_PATH = "/css/bulma-carousel.min.css";

    public static final String FONTS_PATH = "/css/fa5.min.css";
    public static final String FONTS_DEBUG_PATH = "/css/fa5.css";

    public static final String JQUERY_PATH = "/js/jquery-3.6.0.min.js";
    public static final String JQUERY_DEBUG_PATH = "/js/jquery-3.6.0.js";

    public static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public static void addLibs(Model model) {
        model.addAttribute("bulmaPath", DEBUG ? BULMA_DEBUG_PATH : BULMA_PATH);
        model.addAttribute("bulmaCarouselPath", DEBUG ? BULMA_CAROUSEL_DEBUG_PATH: BULMA_CAROUSEL_PATH);
        model.addAttribute("fontsPath", DEBUG ? FONTS_DEBUG_PATH : FONTS_PATH);
        model.addAttribute("jqueryPath", DEBUG ? JQUERY_DEBUG_PATH : JQUERY_PATH);
    }

}
