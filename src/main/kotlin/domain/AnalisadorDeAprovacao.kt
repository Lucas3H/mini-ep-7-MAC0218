package domain

class AnalisadorDeAprovacao {
    private lateinit var criterio: CriterioDeAprovacao

    fun defineCriterio(criterio: CriterioDeAprovacao) {
        this.criterio = criterio
    }

	fun fechaBoletim(boletim: Boletim): BoletimFechado {
        val boletimFechado: BoletimFechado
        boletimFechado.mediaEPs = boletim.mediaEPs
        boletimFechado.mediaMiniEPs = boletim.mediaMiniEPs
        boletimFechado.mediaFinal = this.criterio.mediaFinal(boletim)
        boletimFechado.foiAprovado = this.criterio.estaAprovado(boletim)

        return boletimFechado
    }
}