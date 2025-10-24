package com.example.scientia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TelaAvaliacoes_User : Fragment() {
    private val CONTAINER_ID = R.id.containerFrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tela_avaliacoes__user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbarLivrosTotaisAvaliacoes)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerLivrosTotaisAvaliacoes)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val listaLivrosAv = listOf(
            LivroAvaliacoes(
                "Ciências da Computação",
                "Nell Dale / John Lewis",
                R.drawable.capa_ciencia_computacao,
                "Revista e atualizada com as últimas informações de campo, a quarta edição de Ciência da Computação apresenta a história do hardware e do software, mostrando um sistema computacional como uma cebola. O computador, com sua linguagem de máquina, é o coração da cebola, e camadas de software e hardware mais sofisticados têm sido acrescentadas em volta desse coração, camada por camada. Primeiro, tem-se a linguagem de máquina, parte do centro desta cebola. A camada seguinte é composta de sofisticados sistemas de software, cujo desenvolvimento foi estimulado pelo trabalho teórico em ciência da computação – sem ela, esse programas não se tornariam realidade. A última camada compreende rede e software de rede – isto é, as ferramentas necessárias para que computadores se comuniquem uns com os outros. A internet e a World Wide Web (o famoso www dos endereços da internet) dão os retoques finais nessa camada. O primeiro e o último capítulos formam um par de \\\"bibliocantos\\\": o capítulo 1 descreve o que um sistema computacional é, e o capítulo 17 explica o que sistemas computacionais não podem fazer. Os capítulos intermediários analisam em profundidade as camadas que compõem um sistema computacional.",
                "2018",
                idAv = 34342,
                quantidadeTotalAv = 5,
                quantidadeDisponivelAv = 3
            ),
            LivroAvaliacoes(
                "Matemática Discreta",
                "Clifford Sten",
                R.drawable.capa_matematica_discreta,
                "Esta obra aborda conceitos essenciais da matemática discreta, como árvores de recursão, teoria da probabilidade e indução forte e estrutural, bem como contagem, criptografa a e teoria dos números, grafos e reflexões sobre lógica e comprovação, oferecendo, assim, as bases necessárias para que o leitor possa desenvolver seu raciocínio matemático. Completo e compacto, o livro é voltado para estudantes de ciência da computação, sistemas de informação e análise e desenvolvimento de sistemas.",
                "2015",
                idAv = 546564,
                quantidadeTotalAv = 4,
                quantidadeDisponivelAv = 1
            ),
            LivroAvaliacoes(
                "Computação em Nuvem",
                "Thomas Erl",
                R.drawable.capa_computacao_nuvem,
                "A computação em nuvem tornou-se parte integrante e fundamental da tecnologia da informação. A maior parte da atividade empresarial digital e da inovação tecnológica ocorre com o envolvimento de ambientes de nuvem contemporâneos que fornecem infraestrutura automatizada altamente sofisticada e uma vasta gama de recursos tecnológicos. Construir, interagir ou criar com sucesso um ambiente de nuvem requer uma compreensão de sua mecânica interna comum, camadas arquitetônicas, modelos e controles de segurança. Também requer uma compreensão dos fatores comerciais e econômicos que justificam a adoção e o uso no mundo real de nuvens e de produtos e serviços baseados em nuvem.",
                "2020",
                idAv = 757757,
                quantidadeTotalAv = 3,
                quantidadeDisponivelAv = 1
            )
        )

        recyclerView.adapter = LivroAvaliacoesAdapter(listaLivrosAv) { livro ->
            abrirDetalhesLivro(livro)
        }
    }

    private fun abrirDetalhesLivro(livro: LivroAvaliacoes) {
        val fragment = TelaInfoLivroAndamento_Adm().apply {
            arguments = Bundle().apply {
                putString("titulo", livro.tituloAv)
                putString("autor", livro.autorAv)
                putString("descricao", livro.descricaoAv)
                putString("ano", livro.anoAv)
                putInt("capa", livro.capaResIdAv)
                putInt("quantidadeTotal", livro.quantidadeTotalAv)
                putInt("quantidadeDisponivel", livro.quantidadeDisponivelAv)
            }
        }

        parentFragmentManager.beginTransaction()
            .replace(CONTAINER_ID, fragment)
            .addToBackStack("info_livro")
            .commit()
    }
}