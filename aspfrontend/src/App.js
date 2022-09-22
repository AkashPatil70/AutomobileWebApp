import VendoreRegForm from './Components/VendoreRegForm';
import VendorHome from './Components/VendorHome';
import CustomerRegForm from './Components/CustomerRegForm';
import Home from './Components/Home';
import LoginForm from './Components/Login';
import { BrowserRouter,Route,Routes,Link, useNavigate} from "react-router-dom";
import CustomerHome from './Components/CustomerHome';
import AdminHome from './Components/AdminHome';
import OrderForm from './Components/OrderForm';
import GetAllVendors from './Components/GetAllVendors';

function App() {
  return (
    <div className="App">
    {/*<LoginForm/>
     <VendoreRegForm/>
   
   <CustomerHome/>
<OrderForm/> */}
   
 <>
<BrowserRouter>
      <Routes>
        
        <Route exact path="/" element={<Home/>}></Route>
        <Route  path="/login" element={<LoginForm/>}></Route>
        <Route  path="/registerven" element={<VendoreRegForm/>}></Route>
        <Route  path="/registercus" element={<CustomerRegForm/>}></Route>
        <Route exact path="/customerhome" element={<CustomerHome/>}/>
        <Route exact path="/vendorhome" element={<VendorHome/>}/>
        <Route exact path="/adminhome" element={<AdminHome/>}/>
        <Route exact path="/getallvendors" element={<GetAllVendors/>}/>
        <Route exact path="/orderForm" element={<OrderForm />}/>
        </Routes>
   
</BrowserRouter>
   </>
    </div>
   
  );
}

export default App;
