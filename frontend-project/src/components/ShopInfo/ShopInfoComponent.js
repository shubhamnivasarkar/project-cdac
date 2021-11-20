import React, { Component } from 'react'
import shopinfoService from '../../service/shopinfo.service';

import VendorManu from '../vendor/VendorManu';

class ShopInfoComponent extends Component{
    constructor(props){
        super(props)
         this.state={
             shopInfo:[],
             message:''
         }
          
         this.reloadShopInfoList=this.reloadShopInfoList.bind(this);

        }
       
    componentDidMount(){
        this.reloadShopInfoList();

    }
    reloadShopInfoList(){
        shopinfoService.fetchShopInfo().then(res=>{
            this.setState({shopInfo:res.data})
            console.log(res)
           console.log(this.state.shopInfo)

       },err=>{
           console.log(err);
       })
    }

    render() {
        return (
            <div>
               
               <VendorManu/>
         
          <div className="container">

                <h2 className="text-center">Shop Order Details</h2>
                
                <table className="table table-striped">
                    <thead>
                        <tr>
                           
                            <th>Product Name</th>
                            <th>Qunatity</th>
                            <th>Unit Price</th>
                            <th>Sub Total</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                    {
                            this.state.shopInfo.map(
                        shop =>
                                    <tr key={shop.shopId}>
                                        
                                        <td>{shop.productName}</td>
                                        <td>{shop.qunatity}</td>
                                        <td>{shop.unitPrice}</td>
                                        <td>{shop.subTotal}</td>
                                        <td>{shop.orderDate}</td>

                                    </tr>
                            )
                        }
                    </tbody>
                </table>
                </div>
            </div>
        );
    }


}

export default ShopInfoComponent
