enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(
    val firstName: String, 
    val lastName: String, 
    val formacao: Formacao
)

															 // definindo o que a classe de Usuario deve receber.

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

															 //apenas ajuste de var para val.

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: MutableList<ConteudoEducacional>) {
															 //ajuste de var para val && conteudo educacional para MutableList para que permitisse adicionar conteudo
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }
															 //utilizando a lista mutável de inscritos para add um novo usuario

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
    conteudos.add(conteudo)
    }
															  //criada função para adicionar novos conteudos para a formação
        
}

fun main() {
    val formacao = Formacao(
    	"Formação Back End em Kotlin", 						  
															 //passando nome da formação
    	Nivel.INTERMEDIARIO, 							      
															 //passando nível da formação
    	mutableListOf( 										  
    		ConteudoEducacional("Introdução ao Kotlin"),
            ConteudoEducacional("POO - Kotlin"),
            ConteudoEducacional("Exceptions - Kotlin")
															 //utilizando a mutablelist para criar mais de um conteudo
    	)
    )
    
    val usuario = arrayOf(
        Usuario("Diego", "Brunari", formacao),
        Usuario("Maria", "Luiza", formacao)
    )       												    
															 //criando um novo usuario e setando a formação criada acima
    
    formacao.matricular(*usuario)                               
															 //adicionando novo usuario na variavel da lista de inscritos
    

    formacao.inscritos.forEach { usuario -> print("${usuario.firstName} ${usuario.lastName} | ") }; println("foram cadastrados com sucesso!")
    println("Os conteúdos do curso ${formacao.nome} são: ")
    formacao.conteudos.forEach { println(it.nome) }
}