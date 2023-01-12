package kotlinn.projeto

import java.time.LocalDate
import java.time.format.DateTimeFormatter

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

/*
author: joao pedro
 */

//Nivel do conteudo
enum class Nivel {
    BASICO, INTERMEDIARIO, DIFICIL
}

//Dominio do conteudo do Bootcamp(Se é exclusivo do bootcamp ou já esta na grade de cursos da DIO)
enum class Dominio{
    NATIVO_DIO, EXCLUSIVO
}

//Usuário com nome e email
data class Usuario(var nome: String, var email:String){
    override fun toString(): String {
        return "Nome: $nome, Email: $email\n"
    }
}

//Conteudo educadional. Ex: videos, projetos, desafios de código...
data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel, val dominio: Dominio){
    override fun toString(): String {
        return "$nome | Duracao: $duracao h | nivel:$nivel | Dominio: $dominio\n "
    }
}

//Classe que contém as informações do bootcamp
data class Formacao(
    val nome: String, val conteudos: MutableList<ConteudoEducacional>, val nivel: Nivel, val dataTermino: LocalDate
)

{
    override fun toString(): String {
        //Formata a data de termino do Bootcamp
        val dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val dataString = dataFormat.format(dataTermino)

        return "       Formacao" +
                "\n-----------------------\n" +
                "$nome\n" +
                "-----------------------\n"+
                "      Conteudos\n" +
                "-----------------------\n"+
                "$conteudos" +
                "\n-----------------------\n" +
                "     Matriculados\n" +
                "-----------------------\n" +
                "$inscritos" +
                "\n-----------------------\n" +
                "    Data de termino\n"+
                "-----------------------\n" +
                "      $dataString"+

                "\n===================================="+
                "\n          FIM DO PROGRAMA \n"+
                "====================================\n"
    }

    val inscritos = mutableListOf<Usuario>()

    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }

    fun cancelarMatricula(usuario: Usuario) {
        inscritos.remove(usuario)
    }


}

//Main rodando os principais testes

fun main() {

    /*
    Cenário de Testes 1 -> Cadastro de varios usuários em uma unica vez(Classe: Usuário)
     na formação Javascript de nível básico
    */

    //Conteudo educacional exclusivo do bootcamp
    val decisionEstrucJs = ConteudoEducacional("Estruturas de Decisão em Javascript", 2, Nivel.BASICO, Dominio.EXCLUSIVO)
    val repetitionEstrucJs = ConteudoEducacional("Estruturas de Repetição em Javascript", 2, Nivel.BASICO, Dominio.EXCLUSIVO)
    val dataEstrucJs = ConteudoEducacional("Estruturas de Dados em Javascript", 3, Nivel.INTERMEDIARIO, Dominio.EXCLUSIVO)

    //Conteudo educacional Nativo da DIO
    val linkedinAtrativo = ConteudoEducacional("Deixando seu Linkedin atrativo",2,Nivel.BASICO, Dominio.NATIVO_DIO)
    val artigosDio = ConteudoEducacional("Tranforme seu conhecimento em artigos",1,Nivel.BASICO, Dominio.NATIVO_DIO)

    //Usuários
    val thanos = Usuario("Thanos","manopla@email.com")
    val thor = Usuario("Thor","mjolnir@email.com")
    val loki = Usuario("Loki","chifres@email.com")
    val moonk = Usuario("Moon Knight","khonshu@email.com")

    //Formacao
    val formacaoJs = Formacao("Javascript Endgame - by Vingadores", mutableListOf(decisionEstrucJs, repetitionEstrucJs, dataEstrucJs, artigosDio, linkedinAtrativo),Nivel.BASICO, (LocalDate.of(2023, 3, 20)))
    formacaoJs.matricular(thanos, thor, loki, moonk)

    println(formacaoJs)


    /*
    Cenário de Testes 2 -> Cadastro um usuário por vez(Classe: Usuário)
    na formação Java de nível avançado
    */

    //Conteudo Educacional
    val exeptionsJava = ConteudoEducacional("Tratamento de execoes em Java", 3, Nivel.INTERMEDIARIO, Dominio.EXCLUSIVO)
    val soaJava = ConteudoEducacional("Aquitetura orientada a serviços em Java", 3, Nivel.DIFICIL, Dominio.EXCLUSIVO)
    val microSrvcJava = ConteudoEducacional("Microsservicos em Java", 4, Nivel.DIFICIL,Dominio.EXCLUSIVO)

    //Usuarios
    val bath = Usuario("Bathman","chuveiro@email.com")
    val flash = Usuario("flash","turtle@email.com")
    val ww = Usuario("wwoman","power@email.com")
    val sman = Usuario("Superman","lexluthor@email.com")

    //Formacao
    val javaCut = Formacao("Java Cut - by Snyder", mutableListOf(exeptionsJava, soaJava, microSrvcJava), Nivel.BASICO, (LocalDate.of(2023, 5, 30)))

    javaCut.matricular(bath)
    javaCut.matricular(flash)
    javaCut.matricular(ww)
    javaCut.matricular(sman)

    println(javaCut)

    /*
    Cenario de testes 3 -> usuário cancela a matricula do bootcamp
     */

    //Conteudo Educacional
    val oopKotlin = ConteudoEducacional("Orientacao a Objetos em Kotlin", 4, Nivel.INTERMEDIARIO, Dominio.EXCLUSIVO)
    val functiosKotlin = ConteudoEducacional("Funcoes em Kotlin", 3, Nivel.BASICO, Dominio.EXCLUSIVO)
    val kotlinWithJs = ConteudoEducacional("Kotlin com Node.js", 4, Nivel.DIFICIL,Dominio.EXCLUSIVO)
    val linkedinPremium = ConteudoEducacional("Como usar o Linkedin Premium", 1, Nivel.INTERMEDIARIO,Dominio.EXCLUSIVO)
    val curriculumDio = ConteudoEducacional("Montando um curriculo na DIO", 1, Nivel.BASICO,Dominio.NATIVO_DIO)

    //Usuarios
    val joao = Usuario("Joao","joao@email.com")
    val pedro = Usuario("Pedro","peter@email.com")
    val santana = Usuario("Santana","sant@email.com")
    val varissimo = Usuario("Verissimo","vrssm@email.com")

    //Formacao
    val kotlinOnFire = Formacao("Kotlin on Fire! - by DIO", mutableListOf(oopKotlin, functiosKotlin, kotlinWithJs, linkedinPremium,curriculumDio), Nivel.INTERMEDIARIO, (LocalDate.of(2023, 2, 10)))

    kotlinOnFire.matricular(joao)
    kotlinOnFire.matricular(pedro)
    kotlinOnFire.matricular(santana)
    kotlinOnFire.matricular(varissimo)

    //dois usuários cancelaram a matricula
    kotlinOnFire.cancelarMatricula(santana)
    kotlinOnFire.cancelarMatricula(joao)

    println(kotlinOnFire)
}
