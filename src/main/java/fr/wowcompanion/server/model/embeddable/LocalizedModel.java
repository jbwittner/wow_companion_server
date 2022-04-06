package fr.wowcompanion.server.model.embeddable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import fr.jbwittner.blizzardswagger.wowretailapi.model.NameData;

@Data
@Embeddable
public class LocalizedModel {

    @Column(name="EN_US")
    private String enUS;

    @Column(name="ES_MX")
    private String esMX;

    @Column(name="PT_BR")
    private String ptBR;

    @Column(name="DE_DE")
    private String deDE;

    @Column(name="EN_GB")
    private String enGB;

    @Column(name="ES_ES")
    private String esES;

    @Column(name="FR_FR")
    private String frFR;

    @Column(name="IT_IT")
    private String itIT;

    @Column(name="RU_RU")
    private String ruRU;

    @Column(name="KO_KR")
    private String koKR;

    @Column(name="ZH_TW")
    private String zhTW;

    @Column(name="ZH_CN")
    private String zhCN;

    public void updateLocalizedValue(final NameData nameData){
        this.enUS = nameData.getEnUS();
        this.esMX = nameData.getEsMX();
        this.ptBR = nameData.getPtBR();
        this.deDE = nameData.getDeDE();
        this.enGB = nameData.getEnGB();
        this.esES = nameData.getEsES();
        this.frFR = nameData.getFrFR();
        this.itIT = nameData.getItIT();
        this.ruRU = nameData.getRuRU();
        this.koKR = nameData.getKoKR();
        this.zhTW = nameData.getZhTW();
        this.zhCN = nameData.getZhCN();
    }

}
