package Repositorios;

import ClassesBasicas.Lojas;

public class RepositorioLojasArray  implements  RepositorioLojas {
    private Lojas[] lojas;
    private int indice;

    public RepositorioLojasArray(){
        this.lojas = new Lojas[50];
        this.indice = 0;
    }

   public void inserir(Lojas loja){
        if(this.indice < this.lojas.length){
            lojas[this.indice] = loja;
        }else{
            thro
        }
    }

    public void remover(int id){

        if(this.existe(id)){
            for(int i = 0; i < this.lojas.length; i++){
                if(this.lojas[i].getId() == id){
                    this.lojas[i] = null;
                }
            }

            //organizando a lista
            for(int i = 0; i < this.lojas.length-1; i++){
                if(this.lojas[i+1] != null && this.lojas[i] == null){
                    this.lojas[i] = this.lojas[i+1];
                    this.lojas[i+1] = null;
                }
            }

        }else{
            //erro
        }
    }

    public void atualizar (Lojas loja){
        if(this.existe(loja.getId())){
            for(int i = 0; i < this.lojas.length; i++){
                if(loja.getId() == this.lojas[i].getId()){
                    this.lojas[i] = loja;
                }
            }
        }else{
            //erro
        }
    }

    public boolean existe (int id){

        for(int i = 0; i < this.lojas.length; i++){
            if(this.lojas[i].getId() == id){
                return true;
            }
        }
       return false;
    }

    public Lojas procurar (int id){
        if(this.existe(id)){
            for(int i = 0; i < this.lojas.length; i++){
                if(this.lojas[i].getId() == id){
                    return this.lojas[i];
                }
            }
        }else{
            //erro
        }
        return null;
    }
}
