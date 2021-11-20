import orderService from "../../service/order.service";
import React, { Component } from 'react'
import CustomerManu from "../CustomerManu";


class OrderComponent extends Component{
    constructor(props){
        super(props)
         this.state={
             order:[],
             message:'',
         }
         this.myOrder=this.myOrder.bind(this);
         this.cancelOrder=this.cancelOrder.bind(this)
        
        
      }

      componentDidMount(){
        this.myOrder()
    }

  
      myOrder(){
        orderService.fetchOrderById().then(res=>{
            this.setState({order:res.data})
            console.log('data fached')
            console.log(res.data);

        },err=>{
             console.log(err);
        })
      }

      cancelOrder(orderId){
          console.log(orderId)
          orderService.deleteOrder(orderId).then(res=>{
              this.setState({message:res.data})
              console.log(res.data)
          },err=>{
              console.log(err)
          })
          this.myOrder()
      }

   render(){
       return(
       <div>
           <CustomerManu/>
            <table className="table table-striped">
             
           <thead>
                            <tr>
                               
                               
                                <th>Product Name</th>
                                <th>Unit Price</th>
                                <th>Quantity</th>
                                <th>SubTotal</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>

                        <tbody>
                        {
                            this.state.order.map(
                        order =>  
                                    <tr key={order.orderId}>
                                       
                                       
                                        <td>{order.product.productName}</td>
                                        <td>{order.unitPrice}</td>
                                        <td>{order.quntity}</td>
                                        <td>{order.subtotal}</td>
                                        <td>{order.status}</td>
                                        <div>
                                      <button className="btn btn-danger" onClick={() => this.cancelOrder(order.orderId)} style={{marginLeft: '20px'}}> Cancel Order</button>
                                      </div> 
                                    </tr>
                                    
                            )
                            
                        }
                    </tbody>
                       
                        </table>  
                        

       </div>
       )   
}

}
export default OrderComponent;
