package pl.poznan.put.shopwebsite;

import org.springframework.ui.Model;

public class Constants {

    public static final boolean DEBUG = true;

    public static final String BULMA_PATH = "css/bulma.min.css";
    public static final String BULMA_DEBUG_PATH = "css/bulma.css";

    public static final String JQUERY_PATH = "js/jquery-3.6.0.min.js";
    public static final String JQUERY_DEBUG_PATH = "js/jquery-3.6.0.js";

    public static void addLibs(Model model) {
        model.addAttribute("bulmaPath", DEBUG ? BULMA_DEBUG_PATH : BULMA_PATH);
        model.addAttribute("jqueryPath", DEBUG ? JQUERY_DEBUG_PATH : JQUERY_PATH);
    }

}
