package Conexao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name="podcast")
public class Podcast {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String produtor;
    private String nomeEpisodio;
    private int numeroEpisodio;
    private double durcao;
    private String urlRepositorio;
    
    public Podcast(){}

    public Podcast(int id, String produtor, String nomeEpisodio, int numeroEpisodio, double durcao, String urlRepositorio) {
        this.id = id;
        this.produtor = produtor;
        this.nomeEpisodio = nomeEpisodio;
        this.numeroEpisodio = numeroEpisodio;
        this.durcao = durcao;
        this.urlRepositorio = urlRepositorio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public double getDurcao() {
        return durcao;
    }

    public void setDurcao(double durcao) {
        this.durcao = durcao;
    }

    public String getUrlRepositorio() {
        return urlRepositorio;
    }

    public void setUrlRepositorio(String urlRepositorio) {
        this.urlRepositorio = urlRepositorio;
    } 
}
