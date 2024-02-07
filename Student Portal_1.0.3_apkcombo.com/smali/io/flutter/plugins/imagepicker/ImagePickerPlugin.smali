.class public Lio/flutter/plugins/imagepicker/ImagePickerPlugin;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Lc/a/c/a/i$c;
.implements Lio/flutter/embedding/engine/i/a;
.implements Lio/flutter/embedding/engine/i/c/a;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;,
        Lio/flutter/plugins/imagepicker/ImagePickerPlugin$LifeCycleObserver;
    }
.end annotation


# instance fields
.field private a:Lc/a/c/a/i;

.field private b:Lio/flutter/plugins/imagepicker/e;

.field private c:Lio/flutter/embedding/engine/i/a$b;

.field private d:Lio/flutter/embedding/engine/i/c/c;

.field private e:Landroid/app/Application;

.field private f:Landroid/app/Activity;

.field private g:Landroidx/lifecycle/d;

.field private h:Lio/flutter/plugins/imagepicker/ImagePickerPlugin$LifeCycleObserver;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic h(Lio/flutter/plugins/imagepicker/ImagePickerPlugin;)Lio/flutter/plugins/imagepicker/e;
    .locals 0

    iget-object p0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    return-object p0
.end method

.method private j(Lc/a/c/a/b;Landroid/app/Application;Landroid/app/Activity;Lc/a/c/a/m;Lio/flutter/embedding/engine/i/c/c;)V
    .locals 2

    iput-object p3, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->f:Landroid/app/Activity;

    iput-object p2, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->e:Landroid/app/Application;

    invoke-virtual {p0, p3}, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->i(Landroid/app/Activity;)Lio/flutter/plugins/imagepicker/e;

    move-result-object v0

    iput-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    new-instance v0, Lc/a/c/a/i;

    const-string v1, "plugins.flutter.io/image_picker"

    invoke-direct {v0, p1, v1}, Lc/a/c/a/i;-><init>(Lc/a/c/a/b;Ljava/lang/String;)V

    iput-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->a:Lc/a/c/a/i;

    invoke-virtual {v0, p0}, Lc/a/c/a/i;->e(Lc/a/c/a/i$c;)V

    new-instance p1, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$LifeCycleObserver;

    invoke-direct {p1, p0, p3}, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$LifeCycleObserver;-><init>(Lio/flutter/plugins/imagepicker/ImagePickerPlugin;Landroid/app/Activity;)V

    iput-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->h:Lio/flutter/plugins/imagepicker/ImagePickerPlugin$LifeCycleObserver;

    if-eqz p4, :cond_0

    invoke-virtual {p2, p1}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    iget-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-interface {p4, p1}, Lc/a/c/a/m;->c(Lc/a/c/a/k;)Lc/a/c/a/m;

    iget-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-interface {p4, p1}, Lc/a/c/a/m;->d(Lc/a/c/a/n;)Lc/a/c/a/m;

    goto :goto_0

    :cond_0
    iget-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-interface {p5, p1}, Lio/flutter/embedding/engine/i/c/c;->c(Lc/a/c/a/k;)V

    iget-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-interface {p5, p1}, Lio/flutter/embedding/engine/i/c/c;->d(Lc/a/c/a/n;)V

    invoke-static {p5}, Lio/flutter/embedding/engine/plugins/lifecycle/a;->a(Lio/flutter/embedding/engine/i/c/c;)Landroidx/lifecycle/d;

    move-result-object p1

    iput-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->g:Landroidx/lifecycle/d;

    iget-object p2, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->h:Lio/flutter/plugins/imagepicker/ImagePickerPlugin$LifeCycleObserver;

    invoke-virtual {p1, p2}, Landroidx/lifecycle/d;->a(Landroidx/lifecycle/f;)V

    :goto_0
    return-void
.end method

.method private k()V
    .locals 3

    iget-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->d:Lio/flutter/embedding/engine/i/c/c;

    iget-object v1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-interface {v0, v1}, Lio/flutter/embedding/engine/i/c/c;->f(Lc/a/c/a/k;)V

    iget-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->d:Lio/flutter/embedding/engine/i/c/c;

    iget-object v1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-interface {v0, v1}, Lio/flutter/embedding/engine/i/c/c;->e(Lc/a/c/a/n;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->d:Lio/flutter/embedding/engine/i/c/c;

    iget-object v1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->g:Landroidx/lifecycle/d;

    iget-object v2, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->h:Lio/flutter/plugins/imagepicker/ImagePickerPlugin$LifeCycleObserver;

    invoke-virtual {v1, v2}, Landroidx/lifecycle/d;->c(Landroidx/lifecycle/f;)V

    iput-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->g:Landroidx/lifecycle/d;

    iput-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    iget-object v1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->a:Lc/a/c/a/i;

    invoke-virtual {v1, v0}, Lc/a/c/a/i;->e(Lc/a/c/a/i$c;)V

    iput-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->a:Lc/a/c/a/i;

    iget-object v1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->e:Landroid/app/Application;

    iget-object v2, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->h:Lio/flutter/plugins/imagepicker/ImagePickerPlugin$LifeCycleObserver;

    invoke-virtual {v1, v2}, Landroid/app/Application;->unregisterActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    iput-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->e:Landroid/app/Application;

    return-void
.end method


# virtual methods
.method public a()V
    .locals 0

    invoke-direct {p0}, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->k()V

    return-void
.end method

.method public b(Lio/flutter/embedding/engine/i/c/c;)V
    .locals 6

    iput-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->d:Lio/flutter/embedding/engine/i/c/c;

    iget-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->c:Lio/flutter/embedding/engine/i/a$b;

    invoke-virtual {p1}, Lio/flutter/embedding/engine/i/a$b;->b()Lc/a/c/a/b;

    move-result-object v1

    iget-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->c:Lio/flutter/embedding/engine/i/a$b;

    invoke-virtual {p1}, Lio/flutter/embedding/engine/i/a$b;->a()Landroid/content/Context;

    move-result-object p1

    move-object v2, p1

    check-cast v2, Landroid/app/Application;

    iget-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->d:Lio/flutter/embedding/engine/i/c/c;

    invoke-interface {p1}, Lio/flutter/embedding/engine/i/c/c;->b()Landroid/app/Activity;

    move-result-object v3

    iget-object v5, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->d:Lio/flutter/embedding/engine/i/c/c;

    const/4 v4, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->j(Lc/a/c/a/b;Landroid/app/Application;Landroid/app/Activity;Lc/a/c/a/m;Lio/flutter/embedding/engine/i/c/c;)V

    return-void
.end method

.method public c(Lio/flutter/embedding/engine/i/c/c;)V
    .locals 0

    invoke-virtual {p0, p1}, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b(Lio/flutter/embedding/engine/i/c/c;)V

    return-void
.end method

.method public d(Lio/flutter/embedding/engine/i/a$b;)V
    .locals 0

    const/4 p1, 0x0

    iput-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->c:Lio/flutter/embedding/engine/i/a$b;

    return-void
.end method

.method public e()V
    .locals 0

    invoke-virtual {p0}, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->a()V

    return-void
.end method

.method public f(Lc/a/c/a/h;Lc/a/c/a/i$d;)V
    .locals 4

    iget-object v0, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->f:Landroid/app/Activity;

    if-nez v0, :cond_0

    const/4 p1, 0x0

    const-string v0, "no_activity"

    const-string v1, "image_picker plugin requires a foreground activity."

    invoke-interface {p2, v0, v1, p1}, Lc/a/c/a/i$d;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void

    :cond_0
    new-instance v0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;

    invoke-direct {v0, p2}, Lio/flutter/plugins/imagepicker/ImagePickerPlugin$a;-><init>(Lc/a/c/a/i$d;)V

    const-string p2, "cameraDevice"

    invoke-virtual {p1, p2}, Lc/a/c/a/h;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    const/4 v2, 0x1

    if-eqz v1, :cond_2

    invoke-virtual {p1, p2}, Lc/a/c/a/h;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Ljava/lang/Integer;

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result p2

    if-ne p2, v2, :cond_1

    sget-object p2, Lio/flutter/plugins/imagepicker/a;->b:Lio/flutter/plugins/imagepicker/a;

    goto :goto_0

    :cond_1
    sget-object p2, Lio/flutter/plugins/imagepicker/a;->a:Lio/flutter/plugins/imagepicker/a;

    :goto_0
    iget-object v1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-virtual {v1, p2}, Lio/flutter/plugins/imagepicker/e;->H(Lio/flutter/plugins/imagepicker/a;)V

    :cond_2
    iget-object p2, p1, Lc/a/c/a/h;->a:Ljava/lang/String;

    invoke-virtual {p2}, Ljava/lang/String;->hashCode()I

    const/4 v1, -0x1

    invoke-virtual {p2}, Ljava/lang/String;->hashCode()I

    move-result v3

    sparse-switch v3, :sswitch_data_0

    goto :goto_1

    :sswitch_0
    const-string v3, "retrieve"

    invoke-virtual {p2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-nez p2, :cond_3

    goto :goto_1

    :cond_3
    const/4 v1, 0x3

    goto :goto_1

    :sswitch_1
    const-string v3, "pickVideo"

    invoke-virtual {p2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-nez p2, :cond_4

    goto :goto_1

    :cond_4
    const/4 v1, 0x2

    goto :goto_1

    :sswitch_2
    const-string v3, "pickImage"

    invoke-virtual {p2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-nez p2, :cond_5

    goto :goto_1

    :cond_5
    const/4 v1, 0x1

    goto :goto_1

    :sswitch_3
    const-string v3, "pickMultiImage"

    invoke-virtual {p2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p2

    if-nez p2, :cond_6

    goto :goto_1

    :cond_6
    const/4 v1, 0x0

    :goto_1
    const-string p2, "source"

    packed-switch v1, :pswitch_data_0

    new-instance p2, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Unknown method "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object p1, p1, Lc/a/c/a/h;->a:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p2, p1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p2

    :pswitch_0
    iget-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-virtual {p1, v0}, Lio/flutter/plugins/imagepicker/e;->F(Lc/a/c/a/i$d;)V

    goto :goto_2

    :pswitch_1
    invoke-virtual {p1, p2}, Lc/a/c/a/h;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Ljava/lang/Integer;

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result p2

    if-eqz p2, :cond_8

    if-ne p2, v2, :cond_7

    iget-object p2, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-virtual {p2, p1, v0}, Lio/flutter/plugins/imagepicker/e;->g(Lc/a/c/a/h;Lc/a/c/a/i$d;)V

    goto :goto_2

    :cond_7
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Invalid video source: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_8
    iget-object p2, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-virtual {p2, p1, v0}, Lio/flutter/plugins/imagepicker/e;->K(Lc/a/c/a/h;Lc/a/c/a/i$d;)V

    goto :goto_2

    :pswitch_2
    invoke-virtual {p1, p2}, Lc/a/c/a/h;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p2

    check-cast p2, Ljava/lang/Integer;

    invoke-virtual {p2}, Ljava/lang/Integer;->intValue()I

    move-result p2

    if-eqz p2, :cond_a

    if-ne p2, v2, :cond_9

    iget-object p2, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-virtual {p2, p1, v0}, Lio/flutter/plugins/imagepicker/e;->e(Lc/a/c/a/h;Lc/a/c/a/i$d;)V

    goto :goto_2

    :cond_9
    new-instance p1, Ljava/lang/IllegalArgumentException;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Invalid image source: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    invoke-direct {p1, p2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw p1

    :cond_a
    iget-object p2, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-virtual {p2, p1, v0}, Lio/flutter/plugins/imagepicker/e;->J(Lc/a/c/a/h;Lc/a/c/a/i$d;)V

    goto :goto_2

    :pswitch_3
    iget-object p2, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->b:Lio/flutter/plugins/imagepicker/e;

    invoke-virtual {p2, p1, v0}, Lio/flutter/plugins/imagepicker/e;->f(Lc/a/c/a/h;Lc/a/c/a/i$d;)V

    :goto_2
    return-void

    :sswitch_data_0
    .sparse-switch
        -0x65dc595d -> :sswitch_3
        -0x56dcda46 -> :sswitch_2
        -0x56276f26 -> :sswitch_1
        -0x127abfc4 -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public g(Lio/flutter/embedding/engine/i/a$b;)V
    .locals 0

    iput-object p1, p0, Lio/flutter/plugins/imagepicker/ImagePickerPlugin;->c:Lio/flutter/embedding/engine/i/a$b;

    return-void
.end method

.method final i(Landroid/app/Activity;)Lio/flutter/plugins/imagepicker/e;
    .locals 4

    new-instance v0, Lio/flutter/plugins/imagepicker/d;

    invoke-direct {v0, p1}, Lio/flutter/plugins/imagepicker/d;-><init>(Landroid/content/Context;)V

    invoke-virtual {p1}, Landroid/app/Activity;->getCacheDir()Ljava/io/File;

    move-result-object v1

    new-instance v2, Lio/flutter/plugins/imagepicker/b;

    invoke-direct {v2}, Lio/flutter/plugins/imagepicker/b;-><init>()V

    new-instance v3, Lio/flutter/plugins/imagepicker/g;

    invoke-direct {v3, v1, v2}, Lio/flutter/plugins/imagepicker/g;-><init>(Ljava/io/File;Lio/flutter/plugins/imagepicker/b;)V

    new-instance v2, Lio/flutter/plugins/imagepicker/e;

    invoke-direct {v2, p1, v1, v3, v0}, Lio/flutter/plugins/imagepicker/e;-><init>(Landroid/app/Activity;Ljava/io/File;Lio/flutter/plugins/imagepicker/g;Lio/flutter/plugins/imagepicker/d;)V

    return-object v2
.end method
