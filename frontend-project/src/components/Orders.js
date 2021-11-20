import React,{ Component } from "react";
import orderService from "../service/order.service";
import CustomerManu from "./CustomerManu";


class OrdersView extends Component{

    constructor(){
        super();
        this.state={
            orders:[],
        }

        this.loadOrder=this.loadOrder.bind(this);
    }

    componentDidMount(){
        this.loadOrder();
    }


    loadOrder(){
    orderService.getMyOrder().then( res=>{
        this.setState({orders:res.data})
        console.log(this.state.orders +"data")
    },err=>{
        console.log("found error "+err);

    })
        
    }

     

    render(){
        return<div>
             <CustomerManu/>
             <h2 className="text-center">Orders Details</h2>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th className="hidden">OrderId</th>
                            <th>odate</th>
                            <th>product name</th>
                            <th>quntity</th>
                            <th>subtotal</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.orders.map(
                        order =>
                                    <tr key={order.OrderId}>
                                        <td>{order.product.productName}</td>
                                        <td>{order.Quantity}</td>
                                        <td>{order.subtotal}</td>
                                        <td>
                                            <button className="btn btn-success" onClick={() => console.log("click") }> remove</button>
                                            <button className="btn btn-success" onClick={() => console.log("click")} style={{marginLeft: '20px'}}> addQuntity</button>
                                            
                                        </td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>

            

        </div>
    }

}
export default OrdersView;