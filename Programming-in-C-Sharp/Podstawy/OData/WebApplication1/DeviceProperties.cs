//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace WebApplication1
{
    using System;
    using System.Collections.Generic;
    
    public partial class DeviceProperties
    {
        public int Id { get; set; }
        public Nullable<int> DeviceId { get; set; }
        public string Name { get; set; }
        public int TypeOfValue { get; set; }
        public int Unit { get; set; }
        public int Value { get; set; }
    
        public virtual Devices Devices { get; set; }
    }
}