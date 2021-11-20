import { Component } from "react";
import ViewProfile from "../ViewProfile";
import VendorManu from "./VendorManu";

class VendorHome extends Component{
    

    render(){
        return<div>
                 
          <div className="container">
         
              <VendorManu/>
          <ViewProfile />
          </div>
          

        </div>
    }


}

export default VendorHome;
