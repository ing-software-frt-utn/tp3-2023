using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.NetworkInformation;
using System.Text;
using System.Threading.Tasks;

namespace Domain
{
    public sealed class Sesion
    {
        private static Sesion instance = null;
        private static readonly object padlock = new object();

        Sesion()
        {

        }

        public static Sesion Instance { 
            get { 
                lock(padlock) { 
                    if  (instance == null) { 
                        instance = new Sesion(); 
                    } 
                    
                    return instance; 
                } 
            }
        }
    }
}