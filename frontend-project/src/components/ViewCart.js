import React,{ Component } from "react";
import cartService from "../service/cart.service";
import CustomerManu from "./CustomerManu";


class ViewCart extends Component{

    constructor(props){
        super(props);
        this.state={
            cart:[],
            message:'',

        }

        this.deleteCart = this.deleteCart.bind(this);
        this.editCart = this.editCart.bind(this);
        this.reloadCartList = this.reloadCartList.bind(this);
        this.checkOut=this.checkOut.bind(this);
    }
    componentDidMount(){
        this.reloadCartList();
    }



    reloadCartList(){
        cartService.fetchCart().then(res=>{
            this.setState({cart:res.data})
            console.log(res)
           console.log(this.state.cart)

       },err=>{
           console.log(err);
       })
   }



    deleteCart(cartId){
        
        cartService.deleteCart(cartId)
        .then(res=>{
            this.setState({message:'cart deleted successfully'})
            this.reloadCartList();
        })  
    }


    editCart(cartId){
        window.localStorage.setItem("cartId",cartId)
        this.props.history.push('/edit-cart');
    }

    checkOut(){
        console.log("inside checkout")
        this.props.history.push('/payment');
    }


onChange=(e)=>{
          this.setState({ [e.target.name]: e.target.value });
}


          render() {
            return (
                <div>
                    <CustomerManu/>
                    <h2 className="text-center">Cart Details</h2>
                    <table className="table table-striped">
                        <thead>
                            <tr>
                               
                                <th>Product Name</th>
                                <th>Quantity</th>
                                <th>Action</th>
                               
                            </tr>
                        </thead>
                        <tbody>
                            {
                                
                                this.state.cart.map(
                            cart =>  
                                        <tr key={cart.cartId}>
                                           
                                            <td>{cart.product.productName}</td>
                                            <td>{cart.quantity}</td>
                                            <td>
                                                <button className="btn btn-success" onClick={() => this.deleteCart(cart.cartId)}> Remove</button>
                                                <button className="btn btn-success" onClick={() => this.editCart(cart.cartId)} style={{marginLeft: '20px'}}> Add Quantity</button>
                                               
                                            </td>
                                        </tr>
                                )
                            }
                        </tbody>
                       
                        <div>
                            <br/>
                        <button className="btn btn-success" onClick={() => this.checkOut()} style={{marginLeft: '20px'}}> Check Out</button>

                         </div> 
                         </table>

                        



    
                </div>
            );
        }

}
export default ViewCart;