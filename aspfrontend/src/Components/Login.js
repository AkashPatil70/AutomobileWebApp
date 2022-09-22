import { useReducer, useState } from "react"
import './RegistrationCSS.css'
import { useNavigate } from "react-router-dom";

const init={
    username:"",
    password:""
}

const reducer =(state,action)=>{
    switch(action.type){
    case 'update' :
        return { ...state, [action.field]: action.val};
    case 'clear':
        return init;
    }
}

let LoginForm=()=>{
   let navigate=useNavigate()
        const[user,setUser]=useReducer(reducer,init)
        const[login,setLogin]=useState(false)
        const [errormsg,setErrormsg]=useState("")

        const sendData=(e)=>{
            e.preventDefault();
            console.log("hi");
            const reqData = {
                method: "POST",
                headers: {
                    "content-type":"application/json"
                },
                body: JSON.stringify({
                        username:user.username,
                        password:user.password,                    
                })
    
            }
            console.log(user.username,user.password);
            fetch("http://localhost:8080/logincheck",reqData)
            .then(resp => {
                if(resp.status === 401)
                   setErrormsg("Invalid uid/pwd, Try again");
                else
                    return resp.json();})
            .then(data => 
                    {
                        console.log(JSON.stringify(data))
                        if(data!=null)
                        {
                            setLogin(true)
                            localStorage.setItem("curUser",JSON.stringify(data))
                            localStorage.setItem("isLoggedIn",JSON.stringify(true))
                            if(data.role=="customer")
                                navigate("/customerhome")
                            else if(data.role=="vendor")
                                navigate("/vendorhome")
                            else if(data.role=="admin")
                                navigate("/adminhome")
                        }
                    })   
            }
            /*.then(res=> console.log(res))
            .then(result=>{
                console.log(result)
                const userinfo=JSON.parse(result)
                if(result!=null)
                {
                    setLogin(true)
                    localStorage.setItem("curUser",JSON.stringify(userinfo))
                    localStorage.setItem("isLoggedIn",JSON.stringify(true))
                    if(userinfo.role=="customer")
                    {
                     navigate("/customerhome")
                    }
                    else if(userinfo.role=="vendor")
                    navigate("/vendorhome")
                    else if(userinfo.role=="admin")
                    navigate("/adminhome")
                }
               else
               {
                   alert("invalid request")
               }
            })*/
        
    return(
       <form className="container, box"><br/>
      <h1>Login</h1><br /><br />
      <div>
       Username:<input type="email" name="username" placeholder="abc@gmail.com"  onChange={(e)=>{setUser({type :'update' , field:'username' , val:e.target.value})}}></input>
      </div>
      <div>
       Password:<input type="password"  placeholder="Pass@123*" name="password"  onChange={(e)=>{setUser({type :'update' , field:'password' , val:e.target.value})}}></input>
     </div>
      <button  value="Log In"  onClick={(e)=>{sendData(e)}} className="btn btn-success">Login</button>
       <div  className="already" > Create Account ? <a href="/"> Sign Up </a></div>
       {/*<p style={{display:login?"none":"block"}}>Invalid Username or Password</p>
    <p style={{display:login?"block":"none"}}>{JSON.parse(localStorage.getItem("curUser")).username}</p>
       */}
       {errormsg}
    </form>

     )
     

}   
 export default LoginForm;