package sample.caique.seminfo.mapper

object ErrorMapper {

    operator fun invoke(code: Int): Throwable {
        throw Throwable("error $code")
    }
}