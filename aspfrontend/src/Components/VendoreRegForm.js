
import { useReducer } from "react";
import { useState } from "react";
import { useNavigate} from "react-router-dom";
import LoginForm from "./Login";

const init={
    shopname:"",
    address:"",
    contactno:"",
    email:"",
    shopactnumber:0,
    charges:0.00,
    username:"",
    password:"",
    role:"vendor"
}

const reducer=(state,action)=>{
    switch(action.type){
        case 'update':
            return { ...state, [action.field]: action.val};
        case 'clear':
            return init;
    }
}
let VendoreRegForm=()=>{

        const[vendor,dispatch]=useReducer(reducer,init)
        const[msg,setMsg] =useState("")
    
        const sendData=(e)=>{
            e.preventDefault();
            console.log("hi");
            const reqData = {
                method: "POST",
                headers: {
                    "content-type":"application/json"
                },
                body: JSON.stringify({
                        shopname:vendor.shopname,
                        address:vendor.address,
                        contactno:vendor.contactno,
                        email: vendor.email,
                        shopactnumber: vendor.shopactnumber,
                        charges: vendor.charges,
                        username: vendor.username,
                        password: vendor.password,
                        role: vendor.role
                                    
                })
    
            }
            fetch("http://localhost:8080/register",reqData)
            .then(res=> res.json )
            .then(data=>{
                if(data!=null){
                alert("Registered Successfully Click on login...");
                }
                else{
                    alert("Try again Later....");
                }
            })
        }
        let navigate=useNavigate();
    return(
        <div className="container">

            <h3>Register as a vendor :</h3>
            <hr/>
            <form  className="form">
                <label> Shopename :</label>
                <input type="text" name="shopname" required className="form-control" onChange={(e)=>dispatch({type:'update', field:'shopname' , val:e.target.value})}></input>
                <br/>
                <label> Address :</label>
                <input type="text" name="address" required  className="form-control" onChange={(e)=>dispatch({type:'update', field:'address' , val:e.target.value})}></input>
                <br/>
                <label> Contact No :</label>
                <input type="text" name="contactno" required pattern="[0-9]{10}"  className="form-control" onChange={(e)=>dispatch({type:'update', field:'contactno' , val:e.target.value})}></input>
                <br/>
                <label> Email :</label>
                <input type="Email" name="email" required  className="form-control" onChange={(e)=>dispatch({type:'update', field:'email' , val:e.target.value})}></input>
                <br/>
                <label> Shop Registration No :</label>
                <input type="text" name="shopactnumber" required pattern="[0-9]{4}"  className="form-control" onChange={(e)=>dispatch({type:'update', field:'shopactnumber' , val:e.target.value})}></input>
                <br/>
                <label> Basic servicing charge :</label>
                <input type="text" name="charges" required pattern="[0-9]*"  className="form-control" onChange={(e)=>dispatch({type:'update', field:'charges' , val:e.target.value})}></input>
                <br/>
                <label>Set Username :</label>
                <input type="email" name="username" required  className="form-control" onChange={(e)=>dispatch({type:'update', field:'username' , val:e.target.value})}></input>
                <br/>
                <label> Set Password :</label>
                <input type="password" name="password" required  className="form-control" onChange={(e)=>dispatch({type:'update', field:'password' , val:e.target.value})}></input>
                <br/>
                <input type="hidden" name="role" value="vendor" onChange={(e)=>dispatch({type:'update', field:'role' , val:e.target.value})}></input>
                <input type="submit" value="Register" className="btn btn-primary"  onClick={(e)=>{sendData(e)}}></input>
                <input type="reset" onClick={(e)=>{dispatch({type:'clear'})}}  className="btn btn-primary"></input>
                <br/>
            </form>
            <hr/>
            <button className="btn btn-primary" onClick={()=>{navigate("/login");}}>Log In</button>
        </div>
    )

}

export default VendoreRegForm;



/*import { useReducer } from "react";
import { useState } from "react";
import LoginForm from "./Login";
import { isRouteErrorResponse, useNavigate} from 'react-router-dom';
import { useEffect } from "react";
import './RegistationCSS.css';
const init={
    firstname:"",
    lastname:"",
    contactno:"",
    email:"",
    username:"",
    password:"",
    role:"customer"
}

const reducer=(state,action)=>{
    switch(action.type){
        case 'update':
            return { ...state, [action.field]: action.val};
    }
}
export default function CustomerRegForm()
{
    
    const[customer,dispatch]=useReducer(reducer,init);
    const [formErrors , setFormErrors] = useState([]);
    const [isSubmit,setIsSubmit]= useState(false);
    const [flag,setFlag]=useState(true);

    useEffect(()=>
{
    console.log(formErrors);
    if(Object.keys(formErrors).length === 0 && isSubmit){
       
    }
},[formErrors]);


    const sendData=(e)=>{
        e.preventDefault();
        console.log("hi");

        setFormErrors(validate(customer));
        setIsSubmit(true);
        console.log(customer);

        const reqData = {
            method: "POST",
            headers: {
                "content-type":"application/json"
            },
             body: JSON.stringify({
                    firstname:customer.firstname,
                    lastname:customer.lastname,
                    contactno:customer.contactno,
                    emailid: customer.emailid,
                    username: customer.username,
                    password: customer.password,
                    role: customer.role
                                
            })

        }
        fetch("http://localhost:8080/savecustomer",reqData)
        .then(res=> res.text() )
}

const validate=(data)=>{
    const error={};

    const cnt=/[0-9]{10}/;
    const mail=/[a-z0-9]+@[a-z]+\.[a-z]{2,3}/;
    const passwrd=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/i;

      if(data.firstname=="" ){
            error.firstname="Name is required"
      }
      else if(data.lastname==""){
        error.lastname="Last Name is required"
      }
      else if(data.contactno==""){
        error.contactno="Contact Number is required"
      }
      else if(!cnt.test(data.contactno)){
        error.contactno="enter only digits"
      }
      else if(data.emailid==""){
        error.contactno="Email is required"
      }
      else if(!(mail.test(data.emailid))){
        error.emailid="Please Check email format"
      }
      else if(data.emailid!=data.username){
        error.username="should be same with your entered emailid"
      }
      if(data.password!=""){
        if (data.password.length < 4) {
            error.password = "Password must be more than 4 characters";
        }
        else if (data.password.length > 15) {
            error.password = "Password cannot exceed more than 10 characters";
        }
        else if (!passwrd.test(data.password)) {
            error.password = "Minimum eight characters, at least one letter, one number and one special character:";
        }
      }
      if(data.password==""){
            error.password="Should not be blank"
      }

      return error;

    }
    let navigate=useNavigate();

 return(

        <form className="container, box">
            <div>
            <h1>Register as a Customer :</h1>
            </div>
            <hr/>
            
            <div>
              <tr>
                <td>
            Firstname :
            </td>
            <td>
            <input type="text" name="firstname" required className="form-control" onChange={(e)=>dispatch({type:'update', field:'firstname' , val:e.target.value})}></input>
            </td>
            </tr>
            </div>
            <p>{formErrors.firstname}</p>
             <div>
              <tr>
              <td>
            Lastname :
            </td>
            <td>
            <input type="text" name="lastname" required  className="form-control" onChange={(e)=>dispatch({type:'update', field:'lastname' , val:e.target.value})}></input>
            </td>
            </tr>
            <p>{formErrors.lastname}</p>
            </div>
            <div>
              <tr>
                <td>
             Contact No :
             </td>
             <td>
             <input type="text" name="contactno" required pattern="[0-9]{10}"  className="form-control" onChange={(e)=>dispatch({type:'update', field:'contactno' , val:e.target.value})}></input>
            </td>
            </tr>
            <p>{formErrors.contactno}</p>
           </div>
           <div>
            <tr>
              <td>
             Email :
             </td>
             <td>
             <input type="text" name="emailid" required  className="form-control" onChange={(e)=>dispatch({type:'update', field:'emailid' , val:e.target.value})}></input>
            </td>
            </tr>
            </div>
            <p>{formErrors.emailid}</p>
           <div>
           <tr>
              <td>
             Username :
             </td>
            <td>
             <input type="text" name="username" required  className="form-control" onChange={(e)=>dispatch({type:'update', field:'username' , val:e.target.value})}></input>
           </td>
           </tr>
            </div>
            <p>{formErrors.username}</p>
            <div>
              <tr>
                <td>
            Password :
            </td>
            <td>
            <input type="password" name="password" required  className="form-control" onChange={(e)=>dispatch({type:'update', field:'password' , val:e.target.value})}></input>
            </td>
            </tr>
            </div>
            <p>{formErrors.password}</p>
            <div>
            <input type="hidden" name="role" value="customer" onChange={(e)=>dispatch({type:'update', field:'role' , val:e.target.value})}></input>
            </div>
            <div>
            <tr>
              <td>
            <input type="submit" value="Register" className="btn btn-primary" onClick={(e)=>{sendData(e)}}></input>
            </td>
            </tr>
            </div>
            <br/> 
            <hr/>
            <div>
            <button className="btn btn-primary" onClick={()=>{navigate("/login");}}>Log In</button>    
           </div>
        </form>
     
)
 } */