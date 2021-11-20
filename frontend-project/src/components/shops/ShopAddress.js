import { Component } from "react";
import userService from "../../api/user.service";
import VendorManu from "../vendor/VendorManu";


class ShopAddress extends Component{
    constructor(props){
        super(props);

        this.state={
            addressLine1:"",
            addressLine2:"",
            city:"",
            pinCode:"",
            state:"",
            country:"",
            id:"",
            address:'',
        }
        this.saveUser=this.saveUser.bind(this);    
        this.loadAddress=this.loadAddress.bind(this); 
        this.onchange=this.onchange.bind(this);

    }

    componentDidMount(){
        this.loadAddress();
    }

    loadAddress(){
        userService.getAddress()
        .then(res=>{

            this.setState({address:res.data})
            this.setState({addressLine1:res.data.addressLine1})
            this.setState({addressLine2:res.data.addressLine2})
            this.setState({city:res.data.city})
            this.setState({pinCode:res.data.pinCode})
           
        },err=>{
            console.log("got error  "+err );
        })
    }


onchange(e){
        this.setState({[e.target.name]: e.target.value });
}

        saveUser = (e) => {
            e.preventDefault();
            let newAddress = {id: this.state.id, addressLine1: this.state.addressLine1, addressLine2: this.state.addressLine2, city: this.state.city, pinCode: this.state.pinCode, state: this.state.state,country:this.state.country};
           userService.addEditAddress(newAddress)
                .then(res => {
                    this.setState({message : 'User added successfully.'});
                    this.props.history.push('/vendor');
                });
        }

    render(){
        return<div>

        <VendorManu/>
         
          <div className="container">
            <form onSubmit={this.saveUser}>
        <h2 className="text-center">Address</h2>
            <div className="form-group">
                <label>Address Line 1:</label>
                <input placeholder="Enter your address" required maxLength="30" title="maximum length limit 30" name="addressLine1" className="form-control" value={this.state.addressLine1} onChange={this.onchange}/>
            </div>

            <div className="form-group">
                <label>Address Line 2:</label>
                <input placeholder="Enter your address" maxLength="30" title="maximum length limit 30" name="addressLine2" className="form-control" value={this.state.addressLine2} onChange={this.onchange}/>
            </div>

            <div className="form-group">
                <label>City:</label>
                <input placeholder="Enter city name" required maxLength="30" title="maximum length limit 30" name="city" className="form-control" value={this.state.city} onChange={this.onchange}/>
            </div>

            <div className="form-group">
                <label>Pin Code:</label>
                <input type="text" pattern="[0-9]{6}" title="Pincode should only contain  6 digit number " maxLength="6" required  placeholder="Enter Pin Code" name="pinCode" className="form-control" value={this.state.pinCode} onChange={(e)=>this.onchange(e)}/>
            </div>

            <button className="btn btn-success" >Save</button>
        </form>
        </div>


        </div>
    }



}

export default ShopAddress;