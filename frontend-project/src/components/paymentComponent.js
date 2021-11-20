import React, { Component } from 'react'
import cartService from '../../service/cart.service';
import orderService from '../../service/order.service';
import CustomerManu from '../CustomerManu';



class PaymentComponent extends Component{
    constructor(props){
        super(props)
        this.state={
            payment:'',
              
          }
       
this.placeOrder=this.placeOrder.bind(this);
      }


      componentDidMount(){
        this.reloadPayment();
    }

    reloadPayment(){
         cartService.cartCheckOut().then((res)=>{
            this.setState({payment:res.data})
             console.log(res)
            console.log(this.state.payment.totalAmmount +" data")
            console.log(this.state.payment.userName)

        },err=>{
            console.log(err)
         })
    }



      placeOrder(){
        
        orderService.addOrder().then(res=>{
            console.log(res.data)
            this.props.history.push('/myOrder')
        })
        
    }


   render(){
       
       return(
       <div>
                <CustomerManu/>
                   { this.state.payment.status && <div>
                   <table className="table table-striped">
                     <thead>
                            <tr>
                                <th>UserName</th>
                                <th>Total Amount</th>
                                <th>Date</th>
                                <th>Product_Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                                
                                        <tr>
                                            <td>{this.state.payment.userName}</td>
                                            <td>{this.state.payment.totalAmmount}</td>
                                            <td>{this.state.payment.date}</td>
                                            <td>{this.state.payment.msg}</td>
                                           
                                        </tr>
                            
                                      
                        

                         

                        </tbody>
                        <br/>
                        <button className="btn btn-success" onClick={() => this.placeOrder()} style={{marginLeft: '20px'}}> Place Order</button>
                        </table> 
                        </div> }
                        
                        
                        
                        
                        
                        {  ! this.state.payment.status &&
                            <div>
                        <h4>{this.state.payment.productName} is {this.state.payment.msg}</h4>
                                           <h5>please visit again</h5>
                        </div>
                        }
       </div>
       )   
}

}
export default PaymentComponent
