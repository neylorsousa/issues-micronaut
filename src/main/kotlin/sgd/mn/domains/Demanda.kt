package sgd.mn.domains

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
data class Demanda(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @NotBlank(message = "Assunto não pode ser vazio!")
    @Size(max = 100, message = "Assunto: tamanho deve estar entre 0 e 100 caracteres.")
    val assunto: String?,

    @NotBlank(message = "Descrição não pode ser vazio!")
    val descricao: String?,

    @Column(name = "DATA_FINALIZACAO")
    val dtFinalizacao: LocalDateTime?,

    @ManyToMany(cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "ETIQUETA_DEMANDA",
        joinColumns = [JoinColumn(name = "ID_DEMANDA")],
        inverseJoinColumns = [JoinColumn(name = "ID_ETIQUETA")]
    )
    val etiquetas: Set<Etiqueta>?,

    @NotNull
    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "ID_PESSOA_DEMANDANTE")
    val demandante: Pessoa,

    @NotNull
    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "ID_PESSOA_AUTOR")
    val autor: Pessoa,

    @OneToMany(mappedBy = "demanda", cascade = [CascadeType.ALL])
    val acessos: Set<AcessoDemanda>?,

    @NotNull
    @Enumerated(EnumType.STRING)
    val empresa: Empresa?,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "ID_PRODUTO")
    val produto: Produto?,

    @NotBlank
    val tenant: String,

    @OneToMany(mappedBy = "demanda", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @OrderBy(value = "id")
    val acompanhamentos: Set<Acompanhamento>?,

    @OneToMany(mappedBy = "demanda", cascade = [CascadeType.ALL])
    val campoCustomizados: Set<CampoCustomizado>?,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "ID_DEMANDA_ORIGEM")
    val demandasRelacionadas: Set<DemandaRelacionamento>?,

    @Column(columnDefinition = "boolean default false")
    val fraude: Boolean?,

    //@CreatedDate
    @Column(name = "DATA_INCLUSAO")
    val dtInclusao: LocalDateTime,
)

enum class Empresa {
    POUPEX, FHE
}
