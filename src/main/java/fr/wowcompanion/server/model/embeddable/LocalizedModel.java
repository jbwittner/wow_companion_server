package fr.wowcompanion.server.model.embeddable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import fr.jbwittner.blizzardswagger.wowretailapi.model.NameObjectData;

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

    public void updateLocalizedValue(final NameObjectData nameObjectData){
        this.enUS = nameObjectData.getEnUS();
        this.esMX = nameObjectData.getEsMX();
        this.ptBR = nameObjectData.getPtBR();
        this.deDE = nameObjectData.getDeDE();
        this.enGB = nameObjectData.getEnGB();
        this.esES = nameObjectData.getEsES();
        this.frFR = nameObjectData.getFrFR();
        this.itIT = nameObjectData.getItIT();
        this.ruRU = nameObjectData.getRuRU();
        this.koKR = nameObjectData.getKoKR();
        this.zhTW = nameObjectData.getZhTW();
        this.zhCN = nameObjectData.getZhCN();
    }

}
