package comedor

import org.springframework.web.multipart.MultipartFile

class FeaturedImageCommand {
    MultipartFile imagen
}

class UploadController {

    def subir(FeaturedImageCommand cmd) {
        new File("/tmp/prueba") << cmd.imagen.bytes
        render "ok"
    }

    def bajar() {
        response.outputStream << new File("/tmp/prueba").bytes
    }
}
