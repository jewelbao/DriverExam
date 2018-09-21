package com.jewel.model;

import java.util.List;

import lombok.Data;

@Data
public class CarDetail {


    /**
     * airConfig : [{"name":"空调控制方式","value":"自动1"},{"name":"后排独立空调","value":"-"},{"name":"后座出风口","value":"1"},{"name":"温度分区控制","value":"1"},{"name":"车内空气调节/花粉过滤","value":"1"},{"name":"车载冰箱","value":"-"}]
     * baseInfo : [{"name":"车型名称","value":"Rapide2016款RapideGreatBritainEdition"},{"name":"厂商指导价(元)","value":"318.80万"},{"name":"厂商","value":"阿斯顿·马丁"},{"name":"级别","value":"大型车"},{"name":"发动机","value":"6.0L558马力V12"},{"name":"变速箱","value":"8挡手自一体"},{"name":"长*宽*高(mm)","value":"5019*2140*1360"},{"name":"车身结构","value":"5门4座掀背车"},{"name":"最高车速(km/h)","value":"306"},{"name":"官方0-100km/h加速(s)","value":"4.6"},{"name":"实测0-100km/h加速(s)","value":"-"},{"name":"实测100-0km/h制动(m)","value":"-"},{"name":"实测油耗(L/100km)","value":"-"},{"name":"工信部综合油耗(L/100km)","value":"-"},{"name":"实测离地间隙(mm)","value":"-"},{"name":"整车质保","value":"三年不限公里"}]
     * brand : 阿斯顿·马丁
     * brandName : Rapide
     * carImage : http://f2.mob.com/imgs/2016/06/30/3AA/K52JN3AM6KXU6IRI5KUA_240x180.jpg
     * carbody : [{"name":"长度(mm)","value":"5019"},{"name":"宽度(mm)","value":"2140"},{"name":"高度(mm)","value":"1360"},{"name":"轴距(mm)","value":"2989"},{"name":"前轮距(mm)","value":"-"},{"name":"后轮距(mm)","value":"-"},{"name":"最小离地间隙(mm)","value":"-"},{"name":"整备质量(kg)","value":"-"},{"name":"车身结构","value":"掀背车"},{"name":"车门数(个)","value":"5"},{"name":"座位数(个)","value":"4"},{"name":"油箱容积(L)","value":"91"},{"name":"行李厢容积(L)","value":"-"}]
     * chassis : [{"name":"驱动方式","value":"前置后驱"},{"name":"前悬架类型","value":"螺旋弹簧双叉臂独立悬架"},{"name":"后悬架类型","value":"螺旋弹簧双叉臂独立悬架"},{"name":"助力类型","value":"电动助力"},{"name":"车体结构","value":"承载式"}]
     * controlConfig : [{"name":"ABS防抱死","value":"1"},{"name":"制动力分配(EBD/CBC等)","value":"1"},{"name":"刹车辅助(EBA/BAS/BA等)","value":"1"},{"name":"牵引力控制(ASR/TCS/TRC等)","value":"1"},{"name":"车身稳定控制(ESC/ESP/DSC等)","value":"1"},{"name":"上坡辅助","value":"-"},{"name":"自动驻车","value":"-"},{"name":"陡坡缓降","value":"-"},{"name":"可变悬架","value":"-"},{"name":"空气悬架","value":"-"},{"name":"可变转向比","value":"-"},{"name":"前桥限滑差速器/差速锁","value":"-"},{"name":"中央差速器锁止功能","value":"-"},{"name":"后桥限滑差速器/差速锁","value":"-"}]
     * engine : [{"name":"发动机型号","value":"-"},{"name":"排量(mL)","value":"5935"},{"name":"排量(L)","value":"6.0"},{"name":"进气形式","value":"自然吸气"},{"name":"气缸排列形式","value":"V"},{"name":"气缸数(个)","value":"12"},{"name":"每缸气门数(个)","value":"4"},{"name":"压缩比","value":"-"},{"name":"配气机构","value":"DOHC"},{"name":"缸径(mm)","value":"-"},{"name":"行程(mm)","value":"-"},{"name":"最大马力(Ps)","value":"558"},{"name":"最大功率(kW)","value":"410"},{"name":"最大功率转速(rpm)","value":"6750"},{"name":"最大扭矩(N·m)","value":"620"},{"name":"最大扭矩转速(rpm)","value":"5500"},{"name":"发动机特有技术","value":"-"},{"name":"燃料形式","value":"汽油"},{"name":"燃油标号","value":"97号(京95号)"},{"name":"供油方式","value":"多点电喷"},{"name":"缸盖材料","value":"铝"},{"name":"缸体材料","value":"铝"},{"name":"环保标准","value":"欧IV"}]
     * exterConfig : [{"name":"电动天窗","value":"-"},{"name":"全景天窗","value":"-"},{"name":"运动外观套件","value":"-"},{"name":"铝合金轮圈","value":"1"},{"name":"电动吸合门","value":"-"},{"name":"侧滑门","value":"-"},{"name":"电动后备厢","value":"-"},{"name":"感应后备厢","value":"-"},{"name":"车顶行李架","value":"-"}]
     * glassConfig : [{"name":"前/后电动车窗","value":"前1/后1"},{"name":"车窗防夹手功能","value":"1"},{"name":"防紫外线/隔热玻璃","value":"1"},{"name":"后视镜电动调节","value":"1"},{"name":"后视镜加热","value":"-"},{"name":"内/外后视镜自动防眩目","value":"内1/外-"},{"name":"后视镜电动折叠","value":"1"},{"name":"后视镜记忆","value":"1"},{"name":"后风挡遮阳帘","value":"-"},{"name":"后排侧遮阳帘","value":"-"},{"name":"后排侧隐私玻璃","value":"-"},{"name":"遮阳板化妆镜","value":"1"},{"name":"后雨刷","value":"-"},{"name":"感应雨刷","value":"1"}]
     * interConfig : [{"name":"真皮方向盘","value":"1"},{"name":"方向盘调节","value":"上下+前后调节"},{"name":"方向盘电动调节","value":"-"},{"name":"多功能方向盘","value":"1"},{"name":"方向盘换挡","value":"1"},{"name":"方向盘加热","value":"-"},{"name":"方向盘记忆","value":"-"},{"name":"定速巡航","value":"1"},{"name":"前/后驻车雷达","value":"前1/后1"},{"name":"倒车视频影像","value":"-"},{"name":"行车电脑显示屏","value":"1"},{"name":"全液晶仪表盘","value":"-"},{"name":"HUD抬头数字显示","value":"-"}]
     * lightConfig : [{"name":"近光灯","value":"氙气"},{"name":"远光灯","value":"氙气"},{"name":"日间行车灯","value":"1"},{"name":"自适应远近光","value":"-"},{"name":"自动头灯","value":"1"},{"name":"转向辅助灯","value":"-"},{"name":"转向头灯","value":"1"},{"name":"前雾灯","value":"-"},{"name":"大灯高度可调","value":"1"},{"name":"大灯清洗装置","value":"1"},{"name":"车内氛围灯","value":"-"}]
     * mediaConfig : [{"name":"GPS导航系统","value":"1"},{"name":"定位互动服务","value":"-"},{"name":"中控台彩色大屏","value":"1"},{"name":"蓝牙/车载电话","value":"1"},{"name":"车载电视","value":"-"},{"name":"后排液晶屏","value":"-"},{"name":"220V/230V电源","value":"-"},{"name":"外接音源接口","value":"USB+AUX"},{"name":"CD支持MP3/WMA","value":"1"},{"name":"多媒体系统","value":"多碟CD"},{"name":"扬声器品牌","value":"Bang&Olufsen"},{"name":"扬声器数量","value":"-"}]
     * safetyDevice : [{"name":"主/副驾驶座安全气囊","value":"主1/副1"},{"name":"前/后排侧气囊","value":"前1/后-"},{"name":"前/后排头部气囊(气帘)","value":"前1/后1"},{"name":"膝部气囊","value":"-"},{"name":"胎压监测装置","value":"1"},{"name":"零胎压继续行驶","value":"1"},{"name":"安全带未系提示","value":"1"},{"name":"ISOFIX儿童座椅接口","value":"1"},{"name":"发动机电子防盗","value":"1"},{"name":"车内中控锁","value":"1"},{"name":"遥控钥匙","value":"1"},{"name":"无钥匙启动系统","value":"1"},{"name":"无钥匙进入系统","value":"1"}]
     * seatConfig : [{"name":"座椅材质","value":"真皮"},{"name":"运动风格座椅","value":"1"},{"name":"座椅高低调节","value":"1"},{"name":"腰部支撑调节","value":"1"},{"name":"肩部支撑调节","value":"-"},{"name":"主/副驾驶座电动调节","value":"主1/副1"},{"name":"第二排靠背角度调节","value":"-"},{"name":"第二排座椅移动","value":"-"},{"name":"后排座椅电动调节","value":"-"},{"name":"电动座椅记忆","value":"1"},{"name":"前/后排座椅加热","value":"前1/后1"},{"name":"前/后排座椅通风","value":"-"},{"name":"前/后排座椅按摩","value":"-"},{"name":"第三排座椅","value":"-"},{"name":"后排座椅放倒方式","value":"比例放倒"},{"name":"前/后中央扶手","value":"前1/后1"},{"name":"后排杯架","value":"1"}]
     * seriesName : Rapide2016款RapideGreatBritainEdition
     * sonBrand : 阿斯顿·马丁
     * techConfig : [{"name":"自动泊车入位","value":"-"},{"name":"发动机启停技术","value":"-"},{"name":"并线辅助","value":"-"},{"name":"车道偏离预警系统","value":"-"},{"name":"主动刹车/主动安全系统","value":"-"},{"name":"整体主动转向系统","value":"-"},{"name":"夜视系统","value":"-"},{"name":"中控液晶屏分屏显示","value":"-"},{"name":"自适应巡航","value":"-"},{"name":"全景摄像头","value":"-"}]
     * transmission : [{"name":"简称","value":"8挡手自一体"},{"name":"挡位个数","value":"8"},{"name":"变速箱类型","value":"手自一体变速箱(AT)"}]
     * wheelInfo : [{"name":"前制动器类型","value":"通风盘式"},{"name":"后制动器类型","value":"通风盘式"},{"name":"驻车制动类型","value":"电子驻车"},{"name":"前轮胎规格","value":"245/40R20"},{"name":"后轮胎规格","value":"295/35R20"},{"name":"备胎规格","value":"无"}]
     */

    private String brand;
    private String brandName;
    private String carImage;
    private String seriesName;
    private String sonBrand;
    private List<Value> airConfig;
    private List<Value> baseInfo;
    private List<Value> carbody;
    private List<Value> chassis;
    private List<Value> controlConfig;
    private List<Value> engine;
    private List<Value> exterConfig;
    private List<Value> glassConfig;
    private List<Value> interConfig;
    private List<Value> lightConfig;
    private List<Value> mediaConfig;
    private List<Value> safetyDevice;
    private List<Value> seatConfig;
    private List<Value> techConfig;
    private List<Value> transmission;
    private List<Value> wheelInfo;

    @Data
    public static class Value {
        /**
         * name : 自动泊车入位
         * value : -
         */

        private String name;
        private String value;
    }

}
