
import { useReducer } from "react";
import { useState } from "react";
import LoginForm from "./Login";
import { isRouteErrorResponse, useNavigate} from 'react-router-dom';
import { useEffect } from "react";

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
    const [flag,setFlag]=useState(false);
    const [msg,setMsg]=useState("");

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
       
        if(flag==false){
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
        .then(data=>{
         if(flag==true){
          alert("successfully registered now click on Log in....")  
        }else{
          alert("Failed to register please fill all details....")
        }
        })
      }
    
}

const validate=(data)=>{
    const error={};
     console.log("in validate...");
    const cnt=/[0-9]{10}/;
    const mail=/[a-z0-9]+@[a-z]+\.[a-z]{2,3}/;
    const passwrd=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/i;

      if(data.firstname=="" ){
            error.firstname="Name is required"
            setFlag(true);
            setMsg("Please fill details correctly...");
      }
      else if(data.lastname==""){
        error.lastname="Last Name is required"
        setFlag(true);
        setMsg("Please fill details correctly...");
      }
      else if(data.contactno==""){
        error.contactno="Contact Number is required"
        setFlag(true);
        setMsg("Please fill details correctly...");
      }
      else if(!cnt.test(data.contactno)){
        error.contactno="enter only digits"
        setFlag(true);
        setMsg("Please fill details correctly...");
      }
      else if(data.emailid==""){
        error.contactno="Email is required"
        setFlag(true);
      }
      else if(!(mail.test(data.emailid))){
        error.emailid="Please Check email format"
        setFlag(true);
        setMsg("Please fill details correctly...");
      }
      else if(data.emailid!=data.username){
        error.username="should be same with your entered emailid"
        setFlag(true);
        setMsg("Please fill details correctly...");
      }
    /*  
      if(data.password!=""){
        if (data.password.length < 4) {
            error.password = "Password must be more than 4 characters";
            setFlag(false);
        }
        else if (data.password.length > 15) {
            error.password = "Password cannot exceed more than 10 characters";
            setFlag(false);
        }
        else if (!passwrd.test(data.password)) {
            error.password = "Minimum eight characters, at least one letter, one number and one special character:";
            setFlag(false);
        }
      }
      if(data.password==""){
            error.password="Should not be blank"
            setFlag(false);
      }
*/
      return error;

    }
    let navigate=useNavigate();

 return(

         <div>
          <h1>Register as customer :</h1>
        <form className="container, box">
            Firstname :
            <input type="text" required name="firstname"  onChange={(e)=>dispatch({type:'update', field:'firstname' , val:e.target.value})}></input>
            <p>{formErrors.firstname}</p>
            Lastname :
            <input type="text" name="lastname"  onChange={(e)=>dispatch({type:'update', field:'lastname' , val:e.target.value})}></input>
            <p>{formErrors.lastname}</p>
             Contact No :
             <input type="text" name="contactno" onChange={(e)=>dispatch({type:'update', field:'contactno' , val:e.target.value})}></input>
             <p>{formErrors.contactno}</p>
             Email :
             <input type="text" name="emailid"  onChange={(e)=>dispatch({type:'update', field:'emailid' , val:e.target.value})}></input>
             <p>{formErrors.emailid}</p>
             Username :
             <input type="text" name="username"onChange={(e)=>dispatch({type:'update', field:'username' , val:e.target.value})}></input>
             <p>{formErrors.username}</p>
            Password :<input type="password" name="password"    onChange={(e)=>dispatch({type:'update', field:'password' , val:e.target.value})}></input>
            <p>{formErrors.password}</p>
              <button type="submit"  onClick={(e)=>{sendData(e)}}>Register</button>  
            
            <button onClick={()=>{navigate("/login");}}>Log In</button>    
            <p><b>{msg}</b></p>
        </form>
    
        </div>
       
     
)
 } 
