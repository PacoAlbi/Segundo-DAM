var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllersWithViews();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
}
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.MapControllerRoute(
    name: "BorrarPersona",
    pattern: "BorrarPersona",
    defaults: new { controller = "ListadoPersonas", action = "BorrarPersona" });

app.MapControllerRoute(
    name: "EditarPersona",
    pattern: "EditarPersona",
    defaults: new { controller = "ListadoPersonas", action = "EditarPersona" });

app.Run();
