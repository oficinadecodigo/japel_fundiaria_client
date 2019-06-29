package com.japelapp.network;

import com.japelapp.entidade.Moradia;
import com.japelapp.entidade.Pessoa;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class Marshal {

    public static String marshalPessoa(Pessoa pessoa, String idusuario, String idpessoa) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dados = "";
        HashMap<String, Object> registro = new HashMap<>();
        registro.put("nome", pessoa.getNome());
        registro.put("cpf", pessoa.getCpf());
        registro.put("rg", pessoa.getRg());
        registro.put("nome_mae", pessoa.getNome_mae());
        registro.put("nome_pai", pessoa.getNome_pai());
        registro.put("parentesco", pessoa.getParentesco());
        registro.put("sexo", pessoa.getSexo());
        registro.put("raca", pessoa.getRaca());
        try {
            registro.put("data_nascimento", sdf.format(pessoa.getData_nascimento()));
        } catch (Throwable ex) {
            registro.put("data_nascimento", "0001-01-01");
        }
        registro.put("extra1", "");
        registro.put("email", pessoa.getEmail());
        registro.put("nacionalidade", pessoa.getNacionalidade());
        registro.put("numero_ctps", pessoa.getNumero_cpts());
        registro.put("pis_pasep", pessoa.getPis_pasep());
        registro.put("numero_cadunico", pessoa.getNumero_cadunico());
        registro.put("nis", pessoa.getNis());
        registro.put("escolaridade", pessoa.getEscolaridade());
        registro.put("estado_civil", pessoa.getEstado_civil());
        registro.put("situacao_conjugal", pessoa.getSituacao_conjugal());
        registro.put("profissao", pessoa.getProfissao());
        registro.put("renda_formal", pessoa.getRenda_formal());
        registro.put("situacao_renda_formal", pessoa.getSituacao_renda_formal());
        registro.put("renda_informal", pessoa.getRenda_informal());
        registro.put("situacao_renda_informal", pessoa.getSituacao_renda_informal());
        registro.put("ramo_atividade", pessoa.getRamo_atividade());
        registro.put("empregador", pessoa.getEmpregador());
        registro.put("tempo_servico_empregado_atual", pessoa.getTempo_servico_emprego_atual());
        registro.put("fgts", pessoa.getValor_fgts() > 0 ? 1 : 0);
        registro.put("valor_fgts", pessoa.getValor_fgts());
        registro.put("telefone_fixo", pessoa.getTelefone_fixo());
        registro.put("telefone_movel", pessoa.getTelefone_movel());
        registro.put("telefone_recado", pessoa.getTelefone_recado());
        registro.put("falar_com", pessoa.getFalar_com());
        registro.put("tempo_residencia_imovel", pessoa.getTempo_residencia_imovel());
        registro.put("tempo_residencia_municipio", pessoa.getTempo_residencia_municipio());
        registro.put("interesse_moradia_urbana", pessoa.isInteresse_moradia_urbana() ? 1 : 0);
        registro.put("interesse_moradia_rural", pessoa.isInteresse_moradia_rural() ? 1 : 0);
        registro.put("interesse_lote", pessoa.isInteresse_lote() ? 1 : 0);
        registro.put("interesse_regulacao_fundiaria", pessoa.isInteresse_regulacao_fundiaria() ? 1 : 0);
        registro.put("deficiencia_auditiva_mudez", pessoa.isDeficiencia_auditiva_mudez() ? 1 : 0);
        registro.put("deficiencia_auditiva_surdez", pessoa.isDeficiencia_auditiva_surdez() ? 1 : 0);
        registro.put("deficiencia_cadeirante", pessoa.isDeficiencia_cadeirante() ? 1 : 0);
        registro.put("deficiencia_fisica", pessoa.isDeficiencia_fisica() ? 1 : 0);
        registro.put("deficiencia_intelectual", pessoa.isDeficiencia_intelectual() ? 1 : 0);
        registro.put("deficiencia_nanismo", pessoa.isDeficiencia_nanismo() ? 1 : 0);
        registro.put("deficiencia_visual", pessoa.isDeficiencia_visual() ? 1 : 0);
        registro.put("titular_conjuje_mulher_maria_penha", pessoa.isTitular_conjuge_mulher_maria_penha() ? 1 : 0);
        registro.put("proprietario_imovel", pessoa.isProprietario_imovel() ? 1 : 0);
        registro.put("proprietario_lote", pessoa.isProprietario_lote() ? 1 : 0);
        registro.put("proprietario_imovel_precario", pessoa.isProprietario_imovel_precario() ? 1 : 0);
        registro.put("convenio", pessoa.isConvenio() ? 1 : 0);
        registro.put("tipo", pessoa.getTipo());
        registro.put("foto_pessoa", pessoa.getFoto_pessoa());
        registro.put("foto_cpf", pessoa.getFoto_cpf());
        registro.put("foto_rg", pessoa.getFoto_rg());
        registro.put("foto_rg_verso", pessoa.getFoto_rg_verso());
        registro.put("foto_cnh", pessoa.getFoto_cnh());
        registro.put("foto_carteira_trabalho", pessoa.getFoto_carteira_trabalho());
        registro.put("foto_documento_casa", pessoa.getFoto_documento_casa());
        registro.put("foto_comprovante_renda", pessoa.getFoto_comprovante_renda());
        registro.put("foto_comprovante_estado_civil", pessoa.getFoto_comprovante_estado_civil());
        registro.put("usuario_id", idusuario);
        registro.put("pessoa_id", idpessoa);
        JSONObject jsonObject = new JSONObject(registro);
        dados = jsonObject.toString();
        return dados;
    }

    public static String marshalMoradia(Moradia moradia, String idusuario, String idpessoa) {
        String dados = "";
        HashMap<String, Object> registro = new HashMap<>();
        registro.put("quadra", moradia.getQuadra());
        registro.put("lote", moradia.getLote());
        registro.put("poligonal", moradia.getPoligonal());
        registro.put("endereco", moradia.getEndereco());
        registro.put("numero", moradia.getNumero());
        registro.put("complemento", moradia.getComplemento());
        registro.put("cep", moradia.getCep());
        registro.put("bairro", moradia.getBairro());
        registro.put("cidade", moradia.getCidade());
        registro.put("uf", moradia.getUf());
        try {
            registro.put("area_construida", Float.parseFloat(moradia.getArea_construida()) + "");
        } catch (Throwable ex) {
            registro.put("area_construida", "0");
        }
        registro.put("matricula_imovel", moradia.getMatricula_imovel());
        registro.put("medida_frente", moradia.getMedida_frente());
        registro.put("medida_direita", moradia.getMedida_direita());
        registro.put("medida_esquerda", moradia.getMedida_esquerda());
        registro.put("medida_fundo", moradia.getMedida_fundo());
        registro.put("numero_lote_fundo", moradia.getNumero_lote_fundo());
        registro.put("numero_lote_direito", moradia.getNumero_lote_direita());
        registro.put("numero_lote_esquerdo", moradia.getNumero_lote_esquerda());
        registro.put("rua_frente", moradia.getRua_frente());
        registro.put("rua_direita", moradia.getRua_direita());
        registro.put("rua_esquerda", moradia.getRua_esquerda());
        registro.put("rua_fundo", moradia.getRua_fundo());
        registro.put("selagem", moradia.getSelagem());
        registro.put("latitude", moradia.getLatitude());
        registro.put("longitude", moradia.getLongitude());
        registro.put("altitude", moradia.getAltitude());
        registro.put("zona", moradia.getZona());
        registro.put("situacao_propriedade", moradia.getSituacao_propriedade());
        registro.put("valor_aluguel", moradia.getValor_aluguel());
        registro.put("numero_quartos", moradia.getNumero_quarto());
        registro.put("numero_comodos", moradia.getNumero_comodos());
        registro.put("tipo_construcao", moradia.getTipo_construcao());
        registro.put("outro_tipo_construcao", moradia.getOutro_tipo_construcao());
        registro.put("fonte_energia", moradia.isFonte_energia() ? 1 : 0);
        registro.put("abastecimento_agua", moradia.isAbastecimento_agua() ? 1 : 0);
        registro.put("rede_esgoto", moradia.isRede_esgoto() ? 1 : 0);
        registro.put("coleta_lixo", moradia.isColeta_lixo() ? 1 : 0);
        registro.put("separacao_reciclaveis", moradia.isSeparacao_reciclaveis() ? 1 : 0);
        registro.put("valor_beneficiario_prestacao_continuada", moradia.getValor_beneficio_prestacao_continuada());
        registro.put("valor_bolsa_familia", moradia.getValor_bolsa_familia());
        registro.put("outro_beneficio", moradia.getOutro_beneficio());
        registro.put("area_risco", moradia.isArea_risco() ? 1 : 0);
        registro.put("insalubre", moradia.isInsalubre() ? 1 : 0);
        registro.put("desabrigado", moradia.isDesabrigado() ? 1 : 0);
        registro.put("observacao", moradia.getObservacao());
        registro.put("foto_comprovante_visita", moradia.getFoto_comprovante_visita());
        registro.put("foto_fachada", moradia.getFoto_fachada());
        registro.put("foto_comprovante_agua", moradia.getFoto_comprovante_agua());
        registro.put("foto_comprovante_luz", moradia.getFoto_comprovante_luz());
        registro.put("foto_comprovante_iptu", moradia.getFoto_comprovante_iptu());
        registro.put("foto_documento_cartografico", moradia.getFoto_documento_cartografico());
        registro.put("pessoa_id", idpessoa);
        registro.put("usuario_id", idusuario);
        JSONObject jsonObject = new JSONObject(registro);
        dados = jsonObject.toString();
        return dados;
    }

}
