import { NothingImpl, Black, White } from "../types/nothing";


//Used when service provider are instaniated
//Hold application nothings types config 
export class NothingConfig {

    private nothings: { nothing: NothingImpl, layout: any }[] = [];
    //
    addNothingConfig(_nothing: NothingImpl, _layout: any) {

        if (_layout == undefined || _nothing == undefined) {
            return;
        }

        //Add table layout
        if (_layout["table"] != undefined) {
            this.nothings.push({ nothing: _nothing, layout: _layout })

        }

    }

    //more sys wide css config
    getTableColCss() {
        return "{colspan:1;}";
    }

    //return the mapping of each nothing type to layout (table columns)
    getMapping() {
        var res = [];
        this.nothings.forEach(obj => {
            if (obj.nothing instanceof Black)
                res.push({ black: obj.layout["table"]["cols"] });
            else if (obj.nothing instanceof White)
                res.push({ white: obj.layout["table"]["cols"] });
        });
        return res;
    }

}