/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.PedidosDAO;
import DTO.PedidosDTO;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Ryan
 */
public class FrmPedidos extends javax.swing.JFrame {

    /**
     * Creates new form FrmPedidos
     */
    public FrmPedidos() {
        initComponents();
        ListarValoresPedidos();
        FormatarCampo();
        restaurarDadosComboBoxMesa();
        restaurarDadosComboBoxCliente();
        restaurarDadosComboBoxProdutos();
        restaurarDadosComboBoxFuncionarios();
        this.setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(216, 216, 216));
        getRootPane().setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void FormatarCampo() {
        try {
            MaskFormatter objFormatData = new MaskFormatter("##/##/####");
            objFormatData.install(txtData);
        } catch(ParseException err) {
            System.out.print(err.getMessage());
        }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        btnVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxFuncionario = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbxCardapio = new javax.swing.JComboBox<>();
        txtData = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPedido = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        btnCarregar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbxMesa = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(208, 199, 190));
        setResizable(false);

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel8.setText("Pedidos:");

        btnCadastrar.setBackground(new java.awt.Color(190, 149, 149));
        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(new java.awt.Color(190, 149, 149));
        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtId.setEditable(false);
        txtId.setEnabled(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        btnVoltar.setIcon(new javax.swing.ImageIcon("D:\\Escola2021\\Ead\\Desenvolvimento de Sistemas\\Pizzaria-project - Ryan\\Project_CRUD\\src\\icons\\back.png")); // NOI18N
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVoltarMouseEntered(evt);
            }
        });
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Data:");

        jLabel5.setFont(new java.awt.Font("Lucida Handwriting", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("ID:");

        cbxCliente.setBackground(new java.awt.Color(190, 149, 149));
        cbxCliente.setForeground(new java.awt.Color(190, 149, 149));
        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção" }));

        jLabel2.setFont(new java.awt.Font("Lucida Handwriting", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Cliente:");

        jLabel3.setFont(new java.awt.Font("Lucida Handwriting", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("N° Pedido:");

        cbxFuncionario.setBackground(new java.awt.Color(190, 149, 149));
        cbxFuncionario.setForeground(new java.awt.Color(190, 149, 149));
        cbxFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção" }));

        jLabel4.setFont(new java.awt.Font("Lucida Handwriting", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Funcionário:");

        cbxCardapio.setBackground(new java.awt.Color(190, 149, 149));
        cbxCardapio.setForeground(new java.awt.Color(190, 149, 149));
        cbxCardapio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção" }));
        cbxCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCardapioActionPerformed(evt);
            }
        });

        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        tabelaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Data", "Cliente", "N° Pedido", "Funcionário", "Mesa"
            }
        ));
        tabelaPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaPedido.setFocusable(false);
        tabelaPedido.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabelaPedido.setRowHeight(20);
        tabelaPedido.setSelectionBackground(new java.awt.Color(190, 149, 149));
        tabelaPedido.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tabelaPedido);

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon("D:\\Escola2021\\Ead\\Desenvolvimento de Sistemas\\Pizzaria-project - Ryan\\Project_CRUD\\src\\icons\\search.png")); // NOI18N
        btnPesquisar.setText("PESQUISAR");
        btnPesquisar.setBorderPainted(false);
        btnPesquisar.setContentAreaFilled(false);
        btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPesquisarMouseEntered(evt);
            }
        });
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnCarregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCarregar.setIcon(new javax.swing.ImageIcon("D:\\Escola2021\\Ead\\Desenvolvimento de Sistemas\\Pizzaria-project - Ryan\\Project_CRUD\\src\\icons\\load.png")); // NOI18N
        btnCarregar.setText("CARREGAR");
        btnCarregar.setBorderPainted(false);
        btnCarregar.setContentAreaFilled(false);
        btnCarregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCarregarMouseEntered(evt);
            }
        });
        btnCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAlterar.setIcon(new javax.swing.ImageIcon("D:\\Escola2021\\Ead\\Desenvolvimento de Sistemas\\Pizzaria-project - Ryan\\Project_CRUD\\src\\icons\\change.png")); // NOI18N
        btnAlterar.setText("ALTERAR");
        btnAlterar.setBorderPainted(false);
        btnAlterar.setContentAreaFilled(false);
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAlterarMouseEntered(evt);
            }
        });
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon("D:\\Escola2021\\Ead\\Desenvolvimento de Sistemas\\Pizzaria-project - Ryan\\Project_CRUD\\src\\icons\\exit.png")); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.setBorderPainted(false);
        btnExcluir.setContentAreaFilled(false);
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExcluirMouseEntered(evt);
            }
        });
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Handwriting", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Mesa:");

        cbxMesa.setBackground(new java.awt.Color(190, 149, 149));
        cbxMesa.setForeground(new java.awt.Color(190, 149, 149));
        cbxMesa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem mesa" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(295, 295, 295)
                                .addComponent(jLabel8)
                                .addGap(27, 246, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCarregar)
                            .addComponent(btnAlterar)
                            .addComponent(btnPesquisar))))
                .addGap(48, 48, 48))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbxCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37))))
                .addGap(201, 201, 201))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbxCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCadastrar)
                            .addComponent(btnLimpar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCarregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseEntered
        btnVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnVoltarMouseEntered

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        FrmPrincipal objFrmPrincipal = new FrmPrincipal();
        objFrmPrincipal.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
       txtId.setText("");
       txtData.setText("");
       cbxCliente.setSelectedIndex(0);
       cbxCardapio.setSelectedIndex(0);
       cbxFuncionario.setSelectedIndex(0);
       cbxMesa.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {
            PedidosDAO objPedidoDAO = new PedidosDAO();
            PedidosDTO objPedidoDTO = new PedidosDTO();

            int codCliente, codPedido, codFuncionario, codMesa;
            String dataPed;

            codCliente = cbxCliente.getSelectedIndex();
            codPedido = cbxCardapio.getSelectedIndex();
            codFuncionario = cbxFuncionario.getSelectedIndex();

            if(cbxMesa.getSelectedIndex() != 0) {
                codMesa = cbxMesa.getSelectedIndex();
                objPedidoDTO.setCodMesa(codMesa);        
            } else {
                JOptionPane.showMessageDialog(null, "Selecione outra opção!");
            }

            dataPed = txtData.getText();

            objPedidoDTO.setData(dataPed);
            objPedidoDTO.setCodCliente(codCliente);
            objPedidoDTO.setCodFuncionario(codFuncionario);
            objPedidoDTO.setCodPedido(codPedido);

            objPedidoDAO.CadastrarPedido(objPedidoDTO);
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            ListarValoresPedidos();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro! Não foi possível cadastrar!");
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        ListarValoresPedidos();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarActionPerformed
       CarregarCampos();
    }//GEN-LAST:event_btnCarregarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        AlterarPedido();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o registro?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if(resposta == JOptionPane.YES_OPTION) {
                excluirPedido();
                JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            } 
            ListarValoresPedidos();
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Não é possível excluir registros consumidos por chaves estrangeiras!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbxCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCardapioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCardapioActionPerformed

    private void btnCarregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarregarMouseEntered
         btnCarregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnCarregarMouseEntered

    private void btnAlterarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseEntered
         btnAlterar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnAlterarMouseEntered

    private void btnPesquisarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseEntered
         btnPesquisar.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnPesquisarMouseEntered

    private void btnExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseEntered
         btnExcluir.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnExcluirMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPedidos().setVisible(true);
            }
        });
    }

    Vector<Integer> id_cliente = new Vector<>();
    Vector<Integer> id_produto = new Vector<>();
    Vector<Integer> id_funcionario = new Vector<>();
    Vector<Integer> id_mesa = new Vector<>();
    
    private void restaurarDadosComboBoxCliente() {
        try {
            PedidosDAO objClienteDAO = new PedidosDAO();
            ResultSet rs = objClienteDAO.listarCliente();
            
            while(rs.next()) {
                id_cliente.addElement(rs.getInt(1));
                cbxCliente.addItem(rs.getString(2));
            }
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro !" + erro.getMessage());
        }
    }
    
    private void restaurarDadosComboBoxProdutos() {
        try {
            PedidosDAO objClienteDAO = new PedidosDAO();
            ResultSet rs = objClienteDAO.listarProdutos();
            
            while(rs.next()) {
                id_produto.addElement(rs.getInt(1));
                cbxCardapio.addItem(rs.getString(1));
            }
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro !" + erro.getMessage());
        }
    }
    
    
    private void restaurarDadosComboBoxFuncionarios() {
        try {
            PedidosDAO objClienteDAO = new PedidosDAO();
            ResultSet rs = objClienteDAO.listarFuncionarios();
            
            while(rs.next()) {
                id_funcionario.addElement(rs.getInt(1));
                cbxFuncionario.addItem(rs.getString(2));
            }
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro !" + erro.getMessage());
        }
    }
    
    private void restaurarDadosComboBoxMesa() {
        try {
            PedidosDAO objPedidoDAO = new PedidosDAO();
            ResultSet rs = objPedidoDAO.listarMesa();
            
            while(rs.next()) {
                id_mesa.addElement(rs.getInt(1));
                cbxMesa.addItem(String.valueOf(rs.getInt(3)));
            }
        } catch(SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro !" + erro.getMessage());
        }
    }
    
    
    private void CarregarCampos() {
        try {
            int setar = tabelaPedido.getSelectedRow();
            txtId.setText(tabelaPedido.getModel().getValueAt(setar, 0).toString());
            txtData.setText(tabelaPedido.getModel().getValueAt(setar, 1).toString());
            cbxCliente.setSelectedItem(tabelaPedido.getModel().getValueAt(setar, 2).toString());
            cbxCardapio.setSelectedItem(tabelaPedido.getModel().getValueAt(setar, 3).toString());
            cbxFuncionario.setSelectedItem(tabelaPedido.getModel().getValueAt(setar, 4).toString());
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error.getMessage());
        }
    }
    
    private void AlterarPedido() {
        try {
            PedidosDTO objPedidoDTO = new PedidosDTO();
            PedidosDAO objPedidoDAO = new PedidosDAO();
            String data;
            int codCliente, codFuncionario, codPedido, codMesa; 
            
            data = txtData.getText();
            
            codCliente = cbxCliente.getSelectedIndex();
            codFuncionario = cbxFuncionario.getSelectedIndex();
            codPedido = cbxCardapio.getSelectedIndex();
            codMesa = cbxMesa.getSelectedIndex();
            
            
            objPedidoDTO.setData(data);
            objPedidoDTO.setCodCliente(codCliente);
            objPedidoDTO.setCodFuncionario(codFuncionario);
            objPedidoDTO.setCodPedido(codPedido);
            objPedidoDTO.setCodMesa(codMesa);
            
            objPedidoDAO.alterarPedido(objPedidoDTO);
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch(Exception error) {
            JOptionPane.showMessageDialog(null, "Erro! Não foi possível alterar!");
        }
    }
    
    
    private void excluirPedido() {
        int id_pedido; 
        id_pedido = Integer.parseInt(txtId.getText());
        PedidosDTO objPedidoDTO = new PedidosDTO();
        PedidosDAO objPedidoDAO = new PedidosDAO();
        
        objPedidoDTO.setId_Pedido(id_pedido);
        objPedidoDAO.excluirPedido(objPedidoDTO);
    }
    
    private void ListarValoresPedidos() {
        try { 
            PedidosDAO objPedidoDAO = new PedidosDAO ();
            DefaultTableModel model = (DefaultTableModel) tabelaPedido.getModel();
            model.setNumRows(0);

            ArrayList<PedidosDTO> lista = objPedidoDAO.PesquisarPedido();

            for (int i = 0; i < lista.size(); i++) {
                model.addRow(new Object[]{
                    lista.get(i).getId_Pedido(),
                    lista.get(i).getData(),
                    lista.get(i).getCodCliente(),
                    lista.get(i).getCodPedido(),
                    lista.get(i).getCodFuncionario(),
                    lista.get(i).getCodMesa()
                });
            }
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Listar valores VIEW: " + error);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCarregar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> cbxCardapio;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JComboBox<String> cbxFuncionario;
    private javax.swing.JComboBox<String> cbxMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPedido;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
