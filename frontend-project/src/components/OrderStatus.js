import React,{ Component } from "react";
import deliverService from "../api/deliver.service";
import OrderService from '../api/deliver.service'
import orderService from "../api/order.service";
import CustomerManu from "./CustomerManu";

class OrderStatus extends Component{

    constructor(){
        super();
        this.state={
            Orderstatus:[],
        }

        this.loadOrderStatus=this.loadOrderStatus.bind(this);
    }

   componentDidMount(){
        this.loadOrderStatus(); 
   }

   loadOrderStatus(){
     deliverService.getMyOrderStatus()
      .then(res =>{
            this.setState({Orderstatus:res.data})
      },err=>{
         console.log(err);
      })
   }

   render(){
       return<div>
           <CustomerManu/>

           <h1>orderStatus</h1>


           <table className="table table-striped">
                    <thead>
                        <tr>
                            
                            <th>product Name</th>
                            <th>D_date</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.Orderstatus.map(
                        o =>
                                    <tr key={o.orderId}>
                                        
                                        <td>{o.productName}</td>
                                        <td>{o.excectedDeliveryDate}</td>
                                        <td>{o.status}</td>
                                        
                                    </tr>
                            )
                        }
                    </tbody>
                </table>


       </div>
   }

    

}

export default OrderStatus;