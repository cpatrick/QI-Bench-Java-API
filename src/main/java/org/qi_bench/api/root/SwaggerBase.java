package org.qi_bench.api.root;

import org.qi_bench.api.domain.ServeStaticFile;
import org.qi_bench.api.domain.ServeImage;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/")
public class SwaggerBase {

    final String API_DOCS_JSON              = "api-docs.json";
    final String CSS_HIGHTLIGHT_DEFAULT_CSS = "css/hightlight.default.css";
    final String CSS_QIBENCH_CSS            = "css/qibench.css";
    final String CSS_SCREEN_CSS             = "css/screen.css";
    final String IMAGES_LOGO_SMALL_PNG      = "images/logo_small.png";
    final String IMAGES_PET_STORE_API_PNG   = "images/pet_store_api.png";
    final String IMAGES_THROBBER_GIF        = "images/throbber.gif";
    final String IMAGES_WORDNIK_API_PNG     = "images/wordnik_api.png";
    final String INDEX_HTML                 = "index.html";
    final String LIB_BACKBONE_MIN_JS        = "lib/backbone-min.js";
    final String LIB_HANDLEBARS_1_0_RC_1_JS = "lib/handlebars-1.0.rc.1.js";
    final String LIB_HIGHLIGHT_7_3_PACK_JS  = "lib/highlight.7.3.pack.js";
    final String LIB_JQUERY_1_8_0_MIN_JS    = "lib/jquery-1.8.0.min.js";
    final String LIB_JQUERY_BA_BBQ_MIN_JS   = "lib/jquery.ba-bbq.min.js";
    final String LIB_JQUERY_SLIDETO_MIN_JS  = "lib/jquery.slideto.min.js";
    final String LIB_JQUERY_WIGGLE_MIN_JS   = "lib/jquery.wiggle.min.js";
    final String LIB_SWAGGER_JS             = "lib/swagger.js";
    final String LIB_UNDERSCORE_MIN_JS      = "lib/underscore-min.js";
    final String QIBENCH_OVERVIEW_JS        = "qibench-overview.js";
    final String SWAGGER_UI_JS              = "swagger-ui.js";
    final String SWAGGER_UI_MIN_JS          = "swagger-ui.min.js";


    public SwaggerBase() {
    }

    @GET
    @Path(API_DOCS_JSON)
    @Produces("application/json")
    public StreamingOutput SO_API_DOCS_JSON() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile("apiDocs/api-docs.json");
    }

    @GET
    @Path(CSS_HIGHTLIGHT_DEFAULT_CSS)
    @Produces("text/css")
    public StreamingOutput SO_CSS_HIGHTLIGHT_DEFAULT_CSS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(CSS_HIGHTLIGHT_DEFAULT_CSS);
    }

    @GET
    @Path(CSS_QIBENCH_CSS)
    @Produces("text/css")
    public StreamingOutput SO_CSS_QIBENCH_CSS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(CSS_QIBENCH_CSS);
    }

    @GET
    @Path(CSS_SCREEN_CSS)
    @Produces("text/css")
    public StreamingOutput SO_CSS_SCREEN_CSS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(CSS_SCREEN_CSS);
    }

    @GET
    @Path(IMAGES_LOGO_SMALL_PNG)
    public StreamingOutput SO_IMAGES_LOGO_SMALL_PNG() {
        ServeImage si = new ServeImage();
        return si.StreamImage(IMAGES_LOGO_SMALL_PNG);
    }

    @GET
    @Path(IMAGES_PET_STORE_API_PNG)
    public StreamingOutput SO_IMAGES_PET_STORE_API_PNG() {
        ServeImage si = new ServeImage();
        return si.StreamImage(IMAGES_PET_STORE_API_PNG);
    }

    @GET
    @Path(IMAGES_THROBBER_GIF)
    public StreamingOutput SO_IMAGES_THROBBER_GIF() {
        ServeImage si = new ServeImage();
        return si.StreamImage(IMAGES_THROBBER_GIF);
    }

    @GET
    @Path(IMAGES_WORDNIK_API_PNG)
    public StreamingOutput SO_IMAGES_WORDNIK_API_PNG() {
        ServeImage si = new ServeImage();
        return si.StreamImage(IMAGES_WORDNIK_API_PNG);
    }

    @GET
    @Produces({MediaType.TEXT_HTML})
    public StreamingOutput SO_INDEX_HTML() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(INDEX_HTML);
    }

    @GET
    @Path(LIB_BACKBONE_MIN_JS)
    @Produces("text/javascript")
    public StreamingOutput SO_LIB_BACKBONE_MIN_JS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(LIB_BACKBONE_MIN_JS);
    }

    @GET
    @Path(LIB_HANDLEBARS_1_0_RC_1_JS)
    @Produces("text/javascript")
    public StreamingOutput SO_LIB_HANDLEBARS_1_0_RC_1_JS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(LIB_HANDLEBARS_1_0_RC_1_JS);
    }

    @GET
    @Path(LIB_HIGHLIGHT_7_3_PACK_JS)
    @Produces("text/javascript")
    public StreamingOutput SO_LIB_HIGHLIGHT_7_3_PACK_JS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(LIB_HIGHLIGHT_7_3_PACK_JS);
    }

    @GET
    @Path(LIB_JQUERY_1_8_0_MIN_JS)
    @Produces("text/javascript")
    public StreamingOutput SO_LIB_JQUERY_1_8_0_MIN_JS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(LIB_JQUERY_1_8_0_MIN_JS);
    }

    @GET
    @Path(LIB_JQUERY_BA_BBQ_MIN_JS)
    @Produces("text/javascript")
    public StreamingOutput SO_LIB_JQUERY_BA_BBQ_MIN_JS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(LIB_JQUERY_BA_BBQ_MIN_JS);
    }

    @GET
    @Path(LIB_JQUERY_SLIDETO_MIN_JS)
    @Produces("text/javascript")
    public StreamingOutput SO_LIB_JQUERY_SLIDETO_MIN_JS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(LIB_JQUERY_SLIDETO_MIN_JS);
    }

    @GET
    @Path(LIB_JQUERY_WIGGLE_MIN_JS)
    @Produces("text/javascript")
    public StreamingOutput SO_LIB_JQUERY_WIGGLE_MIN_JS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(LIB_JQUERY_WIGGLE_MIN_JS);
    }

    @GET
    @Path(LIB_SWAGGER_JS)
    @Produces("text/javascript")
    public StreamingOutput SO_LIB_SWAGGER_JS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(LIB_SWAGGER_JS);
    }

    @GET
    @Path(LIB_UNDERSCORE_MIN_JS)
    @Produces("text/javascript")
    public StreamingOutput SO_LIB_UNDERSCORE_MIN_JS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(LIB_UNDERSCORE_MIN_JS);
    }

    @GET
    @Path(QIBENCH_OVERVIEW_JS)
    @Produces("text/javascript")
    public StreamingOutput SO_QIBENCH_OVERVIEW_JS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(QIBENCH_OVERVIEW_JS);
    }

    @GET
    @Path(SWAGGER_UI_JS)
    @Produces("text/javascript")
    public StreamingOutput SO_SWAGGER_UI_JS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(SWAGGER_UI_JS);
    }

    @GET
    @Path(SWAGGER_UI_MIN_JS)
    @Produces("text/javascript")
    public StreamingOutput SO_SWAGGER_UI_MIN_JS() {
        ServeStaticFile ssf = new ServeStaticFile();
        return ssf.StaticFile(SWAGGER_UI_MIN_JS);
    }

}
