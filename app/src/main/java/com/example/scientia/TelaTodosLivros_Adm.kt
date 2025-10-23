package com.example.scientia

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scientia.Livro
import com.example.scientia.LivroAdapter
import com.example.scientia.R
import com.example.scientia.TelaInfoLivroAndamento_Adm

class TelaTodosLivros_Adm : Fragment() {

    private val CONTAINER_ID = R.id.containerFrameLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LivroAdapter
    private lateinit var listaOriginal: List<Livro>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_todos_livros__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbarLivrosTotais)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val searchView = view.findViewById<SearchView>(R.id.searchViewLivros)

        searchView.setOnClickListener {
            searchView.isIconified = false
            searchView.requestFocus()
            val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(searchView.findFocus(), InputMethodManager.SHOW_IMPLICIT)
        }

        recyclerView = view.findViewById(R.id.recyclerLivrosTotais)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        listaOriginal = listOf(
            Livro(
                "Ciências da Computação",
                "Nell Dale / John Lewis",
                R.drawable.capa_ciencia_computacao,
                "Revista e atualizada com as últimas informações de campo, a quarta edição de Ciência da Computação apresenta a história do hardware e do software, mostrando um sistema computacional como uma cebola. O computador, com sua linguagem de máquina, é o coração da cebola, e camadas de software e hardware mais sofisticados têm sido acrescentadas em volta desse coração, camada por camada. Primeiro, tem-se a linguagem de máquina, parte do centro desta cebola. A camada seguinte é composta de sofisticados sistemas de software, cujo desenvolvimento foi estimulado pelo trabalho teórico em ciência da computação – sem ela, esse programas não se tornariam realidade. A última camada compreende rede e software de rede – isto é, as ferramentas necessárias para que computadores se comuniquem uns com os outros. A internet e a World Wide Web (o famoso www dos endereços da internet) dão os retoques finais nessa camada. O primeiro e o último capítulos formam um par de \\\"bibliocantos\\\": o capítulo 1 descreve o que um sistema computacional é, e o capítulo 17 explica o que sistemas computacionais não podem fazer. Os capítulos intermediários analisam em profundidade as camadas que compõem um sistema computacional.",
                "2018",
                id = 43543,
                quantidadeTotal = 5,
                quantidadeDisponivel = 3
            ),
            Livro(
                "Matemática Discreta",
                "Clifford Sten",
                R.drawable.capa_matematica_discreta,
                "Esta obra aborda conceitos essenciais da matemática discreta, como árvores de recursão, teoria da probabilidade e indução forte e estrutural, bem como contagem, criptografa a e teoria dos números, grafos e reflexões sobre lógica e comprovação, oferecendo, assim, as bases necessárias para que o leitor possa desenvolver seu raciocínio matemático. Completo e compacto, o livro é voltado para estudantes de ciência da computação, sistemas de informação e análise e desenvolvimento de sistemas.",
                "2015",
                id = 23322,
                quantidadeTotal = 4,
                quantidadeDisponivel = 1
            ),
            Livro(
                "Computação em Nuvem",
                "Thomas Erl",
                R.drawable.capa_computacao_nuvem,
                "A computação em nuvem tornou-se parte integrante e fundamental da tecnologia da informação. A maior parte da atividade empresarial digital e da inovação tecnológica ocorre com o envolvimento de ambientes de nuvem contemporâneos que fornecem infraestrutura automatizada altamente sofisticada e uma vasta gama de recursos tecnológicos. Construir, interagir ou criar com sucesso um ambiente de nuvem requer uma compreensão de sua mecânica interna comum, camadas arquitetônicas, modelos e controles de segurança. Também requer uma compreensão dos fatores comerciais e econômicos que justificam a adoção e o uso no mundo real de nuvens e de produtos e serviços baseados em nuvem.",
                "2020",
                id = 34324,
                quantidadeTotal = 3,
                quantidadeDisponivel = 1
            )
        )

        adapter = LivroAdapter(listaOriginal) { livro ->
            abrirDetalhesLivro(livro)
        }
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val texto = newText ?: ""
                filtrarLista(texto)
                return true
            }
        })
    }

    private fun filtrarLista(query: String) {
        if (query.isEmpty()) {
            adapter.updateList(listaOriginal)
            return
        }

        val listaFiltrada = listaOriginal.filter { livro ->
            livro.titulo.contains(query, ignoreCase = true)
        }

        adapter.updateList(listaFiltrada)
    }

    private fun abrirDetalhesLivro(livro: Livro) {
        val fragment = TelaInfoLivroAndamento_Adm()
        val bundle = Bundle()
        bundle.putString("titulo", livro.titulo)
        bundle.putString("autor", livro.autor)
        bundle.putString("descricao", livro.descricao)
        bundle.putString("ano", livro.ano)
        bundle.putInt("capa", livro.capaResId)
        bundle.putInt("quantidadeTotal", livro.quantidadeTotal)
        bundle.putInt("quantidadeDisponivel", livro.quantidadeDisponivel)

        fragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(CONTAINER_ID, fragment)
            .addToBackStack("info_livro")
            .commit()
    }
}