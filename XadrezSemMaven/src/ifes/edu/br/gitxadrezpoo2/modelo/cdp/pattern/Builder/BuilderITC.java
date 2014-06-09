/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifes.edu.br.gitxadrezpoo2.modelo.cdp.pattern.Builder;

import poo.xadrez.modelo.cdp.Tabuleiro;

/**
 *
 * @author Junior
 */
public interface BuilderITC {
    public Tabuleiro CriarTabuleiro();
    public void AlocarPeao();
    public void AlocarTorre();
    public void AlocarCavalo();
    public void AlocarBispo();
    public void AlocarRei();
    public void AlocarRainha();
    public void AlocarCasa();
}
