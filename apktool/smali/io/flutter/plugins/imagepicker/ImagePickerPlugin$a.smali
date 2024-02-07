.class Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Lc/a/c/a/i$d;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/flutter/plugins/imagepicker/ImagePickerPlugin;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "a"
.end annotation


# instance fields
.field private a:Lc/a/c/a/i$d;

.field private b:Landroid/os/Handler;


# direct methods
.method constructor <init>(Lc/a/c/a/i$d;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;->a:Lc/a/c/a/i$d;

    new-instance p1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {p1, v0}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;->b:Landroid/os/Handler;

    return-void
.end method

.method static synthetic d(Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;)Lc/a/c/a/i$d;
    .locals 0

    iget-object p0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;->a:Lc/a/c/a/i$d;

    return-object p0
.end method


# virtual methods
.method public a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 2

    iget-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;->b:Landroid/os/Handler;

    new-instance v1, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a$b;

    invoke-direct {v1, p0, p1, p2, p3}, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a$b;-><init>(Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public b(Ljava/lang/Object;)V
    .locals 2

    iget-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;->b:Landroid/os/Handler;

    new-instance v1, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a$a;

    invoke-direct {v1, p0, p1}, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a$a;-><init>(Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method public c()V
    .locals 2

    iget-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;->b:Landroid/os/Handler;

    new-instance v1, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a$c;

    invoke-direct {v1, p0}, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a$c;-><init>(Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    return-void
.end method
